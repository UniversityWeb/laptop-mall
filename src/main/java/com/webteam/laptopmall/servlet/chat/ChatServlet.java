package com.webteam.laptopmall.servlet.chat;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.exception.UserNotFoundException;
import com.webteam.laptopmall.service.login.LoginService;
import com.webteam.laptopmall.service.login.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/chat/salesperson")
public class ChatServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ChatServlet.class.getName());
    protected LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/WEB-INF/views/access-denied.html";
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        try {
            User.ERole role = loginService.getRoleByUsername(username);
            if (role.equals(User.ERole.SALESPERSON)) {
                url = "/WEB-INF/views/salesperson-chatbox.jsp";
            }
        } catch (UserNotFoundException e) {
            log.severe(e.getMessage());
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
