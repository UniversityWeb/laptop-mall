package com.webteam.laptopmall.user.controller;

import com.webteam.laptopmall.file.user.UserImgIO;
import com.webteam.laptopmall.file.user.UserImgIOImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update-avatar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UpdateAvatarServlet extends HttpServlet {

    private UserImgIO userImgIO;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userImgIO = new UserImgIOImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Part part = req.getPart("avatarUrl");

        if (part != null) {
            String realPath = req.getServletContext().getRealPath("/");
            userImgIO.save(realPath, username, part);
        }

        HttpSession session = req.getSession();
        req.setAttribute("userRole", userService.getByUsername(session.getAttribute("username").toString()).getRole());

        String url = "/user-profile";
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + url);
    }
}
