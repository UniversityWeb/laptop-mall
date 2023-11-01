package com.webteam.laptopmall.servlet;

import com.webteam.laptopmall.service.login.LoginService;
import com.webteam.laptopmall.service.login.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/WEB-INF/views/login.html";
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String plainPass = req.getParameter("plainPass");
        boolean isSuccess = loginService.login(username, plainPass);
        String url;
        if (isSuccess) {
            req.getSession().setAttribute("username", username);
            url = "/WEB-INF/views/home.jsp";
        } else {
            url = "/WEB-INF/views/login.html";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
