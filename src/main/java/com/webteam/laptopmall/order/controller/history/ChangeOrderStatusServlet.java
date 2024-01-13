package com.webteam.laptopmall.order.controller.history;

import com.webteam.laptopmall.order.OrderDTO;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.order.service.OrderService;
import com.webteam.laptopmall.order.service.OrderServiceImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;
import com.webteam.laptopmall.cart.controller.crud.AddItemServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/change-order-status")
public class ChangeOrderStatusServlet extends HttpServlet {
    private OrderService orderService;
    private UserService userService;

    private static final Logger logger = Logger.getLogger(AddItemServlet.class.getName());
    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/order-details";

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserDTO customer = userService.getByUsername(username);

        String status = req.getParameter("status");
        String orderIdString = req.getParameter("orderId");

        Long orderId = Long.valueOf(orderIdString);
        OrderDTO orderHistory = orderService.getByUserAndOrderId(customer.getId(), orderId);

        orderHistory.setStatus(Order.EStatus.valueOf(status));
        orderService.update(orderHistory);

        req.setAttribute("orderId", orderId);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
