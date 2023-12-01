package com.webteam.laptopmall.servlet.home;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.service.login.LoginService;
import com.webteam.laptopmall.service.login.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home-page")
public class HomeServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = (String) req.getSession().getAttribute("username");
        User.ERole role = loginService.getRoleByUsername(username);
        String url = getUrlByRole(role);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private String getUrlByRole(User.ERole role) {
        String url;
        if (role == User.ERole.SALESPERSON) {
            url = "/WEB-INF/views/seller-main-page.jsp";
        } else if (role == User.ERole.CUSTOMER) {
            url = "/WEB-INF/views/customer-main-page.jsp";
        } else {
            url = "/WEB-INF/views/access-denied.html";
        }
        return url;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
