package com.webteam.laptopmall.servlet.login;

import com.webteam.laptopmall.service.user.UserService;
import com.webteam.laptopmall.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/WEB-INF/views/login.jsp";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String plainPass = req.getParameter("plainPass");
        boolean isSuccess = userService.login(username, plainPass);
        if (isSuccess) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/home-page");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/views/access-denied.html").forward(req, resp);
        }
    }
}
