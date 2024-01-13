package com.webteam.laptopmall.realtimechat.controller;

import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.user.UserNotFoundException;
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

@WebServlet("/chat/salesperson")
public class ChatServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(ChatServlet.class);

    protected UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/WEB-INF/views/access-denied.jsp";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        try {
            User.ERole role = userService.getRoleByUsername(username);
            if (role.equals(User.ERole.SALESPERSON)) {
                url = "/WEB-INF/views/salesperson-chatbox.jsp";
            }
            log.info("User '{}' accessed the servlet with role '{}'", username, role);
        } catch (UserNotFoundException e) {
            log.error("Error retrieving user role: {}", e.getMessage());
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}

