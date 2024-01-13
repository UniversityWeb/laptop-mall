package com.webteam.laptopmall.user.controller;

import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-accounts")
public class GetAccountServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/WEB-INF/views/accounts.jsp";

        List<UserDTO> customers = userService.getUsersByRole(User.ERole.CUSTOMER);
        List<UserDTO> salesperons = userService.getUsersByRole(User.ERole.SALESPERSON);
        req.setAttribute("customerAccounts", customers);
        req.setAttribute("salespersonAccounts", salesperons);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}

