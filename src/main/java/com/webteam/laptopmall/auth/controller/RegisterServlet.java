package com.webteam.laptopmall.auth.controller;

import com.webteam.laptopmall.user.EGender;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;
import com.webteam.laptopmall.util.PassUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
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
        String hashedPass = PassUtil.hashPass(plainPass);
        String phoneNo = req.getParameter("phoneNo");
        String username = req.getParameter("username");

        UserDTO userDTO = new UserDTO(address, email, fullName, gender, phoneNo, username, hashedPass, User.ERole.CUSTOMER);

        UserDTO saved = userService.register(userDTO);
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