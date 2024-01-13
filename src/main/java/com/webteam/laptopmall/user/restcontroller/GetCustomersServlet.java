package com.webteam.laptopmall.user.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/salesperson/get-customers")
public class GetCustomersServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(GetCustomersServlet.class);

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonCustomerUsernames = getAllCustomerUsernames();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();
        pw.println(jsonCustomerUsernames);
        pw.close();
    }

    private String getAllCustomerUsernames() {
        List<String> customerUsernames = userService.getAllCustomerUsernames();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(customerUsernames);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "";
        }
    }
}
