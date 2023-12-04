package com.webteam.laptopmall.servlet.user;

import com.webteam.laptopmall.form.PassUpdateForm;
import com.webteam.laptopmall.service.user.UserService;
import com.webteam.laptopmall.service.user.UserServiceImpl;
import com.webteam.laptopmall.utility.PassUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-password")
public class UpdatePasswordServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = Long.valueOf(idStr);
        String oldPlainPass = req.getParameter("oldPlainPass");
        String newPlainPass = req.getParameter("newPlainPass");
        String reTypePlainPass = req.getParameter("reTypePlainPass");

        PassUpdateForm passUpdateForm = new PassUpdateForm(oldPlainPass, newPlainPass, reTypePlainPass);
        boolean isValid = userService.isValid(id, passUpdateForm);
        if (isValid) {
            String newHashedPass = PassUtil.hashPass(newPlainPass);
            userService.updatePassOnly(id, newHashedPass);
        }

        String url = "/user-profile";
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + url);
    }
}
