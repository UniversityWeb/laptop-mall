package com.webteam.laptopmall.servlet.user;

import com.webteam.laptopmall.io.image.user.UserImgIO;
import com.webteam.laptopmall.io.image.user.UserImgIOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/update-avatar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UpdateAvatarServlet extends HttpServlet {

    private UserImgIO userImgIO;

    @Override
    public void init() throws ServletException {
        super.init();
        userImgIO = new UserImgIOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Part part = req.getPart("avatarUrl");

        if (part != null) {
            String realPath = req.getServletContext().getRealPath("/");
            userImgIO.save(realPath, username, part);
        }

        String url = "/user-profile";
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + url);
    }
}
