package com.webteam.laptopmall.servlet.login;

import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.service.login.LoginService;
import com.webteam.laptopmall.service.login.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genders", EGender.values());
        String url = "/WEB-INF/views/register.jsp";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String genderStr = req.getParameter("genderStr");
        EGender gender = EGender.valueOf(genderStr);
        String plainPass = req.getParameter("plainPass");
        String hashedPass = loginService.hashPass(plainPass);
        String phoneNo = req.getParameter("phoneNo");
        String username = req.getParameter("username");

        UserDTO userDTO = new UserDTO(address, email, fullName, gender, phoneNo, username, hashedPass, User.ERole.CUSTOMER);

        UserDTO saved = loginService.register(userDTO);
        String url;
        if (saved != null) {
            req.getSession().setAttribute("username", username);
            url = "/home-page";
        } else {
            req.setAttribute("user", userDTO);
            url = "/WEB-INF/views/register.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
