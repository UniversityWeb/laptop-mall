package com.webteam.laptopmall.servlet.history;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.service.order.OrderService;
import com.webteam.laptopmall.service.order.OrderServiceImpl;
import com.webteam.laptopmall.service.user.UserService;
import com.webteam.laptopmall.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class HistoryOrderServlet extends HttpServlet {
    private OrderService orderService;
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "//WEB-INF/views/history/order-history.jsp";

        HttpSession session = req.getSession();
        String tab = req.getParameter("tab");
        String username = (String) session.getAttribute("username");
        UserDTO customer = userService.getByUsername(username);
        if (tab == null){
            tab = "ALL";
        }

        List<OrderDTO> ordersHistory;
        if (tab.equals("ALL")){
            ordersHistory = orderService.getListByUserId(customer.getId());
        }
        else {
            ordersHistory = orderService.getListByUserIdAndStatus(customer.getId(), Order.EStatus.valueOf(tab));
        }

        if (ordersHistory.size()<1){
            url = "/WEB-INF/views/history/order-history-empty.jsp";
        }

        req.setAttribute("ordersHistory", ordersHistory);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
