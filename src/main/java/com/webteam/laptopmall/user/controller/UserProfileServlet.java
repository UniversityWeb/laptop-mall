package com.webteam.laptopmall.user.controller;

import com.webteam.laptopmall.user.EGender;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.user.UserNotFoundException;
import com.webteam.laptopmall.file.user.UserImgIO;
import com.webteam.laptopmall.file.user.UserImgIOImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user-profile")
public class UserProfileServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(UserProfileServlet.class);

    private UserService uService;
    private UserImgIO userImgIO;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        uService = new UserServiceImpl();
        userImgIO = new UserImgIOImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String url = "/WEB-INF/views/access-denied.jsp";
        String realPath = req.getServletContext().getRealPath("/");
        try {
            UserDTO userDTO = uService.getByUsername(username);
            userDTO = userImgIO.loadJstlImgUrl(realPath, userDTO);
            req.setAttribute("user", userDTO);
            req.setAttribute("genders", EGender.values());
            url = "/WEB-INF/views/customer-profile.jsp";
        } catch (UserNotFoundException e) {
            log.error(e.getMessage());
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String idStr = req.getParameter("id");
        Long id = Long.valueOf(idStr);
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String genderStr = req.getParameter("genderStr");
        EGender gender = EGender.valueOf(genderStr);
        String phoneNo = req.getParameter("phoneNo");
        String username = req.getParameter("username");

        UserDTO userDTO = new UserDTO(id, address, email, fullName, gender, phoneNo, username);

        int rowCount = uService.updateWithoutPassword(userDTO);
        if (rowCount > 0) {
            req.getSession().setAttribute("username", username);
        }

        HttpSession session = req.getSession();
        req.setAttribute("userRole", userService.getByUsername(session.getAttribute("username").toString()).getRole());

        String url = "/user-profile";
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + url);
    }
}
