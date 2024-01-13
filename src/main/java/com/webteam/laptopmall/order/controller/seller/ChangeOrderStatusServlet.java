package com.webteam.laptopmall.order.controller.seller;

import com.webteam.laptopmall.order.OrderDTO;
import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/seller-change-order-status")
public class ChangeOrderStatusServlet extends HttpServlet {
    private OrderService orderService;
    private ProdImgIO prodImgIO;
    private static final Logger log = Logger.getLogger(AddItemServlet.class.getName());
    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/seller-orders.jsp";
        boolean isSuccessful=false;
        HttpSession session = req.getSession();
        Long customerID = Long.valueOf(req.getParameter("userId"));
        String realPath = req.getServletContext().getRealPath("/");

        String status = req.getParameter("status");
        String orderIdString = req.getParameter("orderId");

        Long orderId = Long.valueOf(orderIdString);

        try {
            OrderDTO orderHistory = orderService.getByUserAndOrderId(customerID, orderId);
            orderHistory.setStatus(Order.EStatus.valueOf(status));
            orderService.update(orderHistory);
            isSuccessful = true;
        } catch (Exception e){
            log.log(Level.SEVERE, e.getMessage());
        }

        List<OrderDTO> orders = orderService.getALl();
        orders.forEach(order -> order.getOrderItems().forEach(orderItem -> orderItem.setProduct(prodImgIO.loadProdImageUrls(orderItem.getProduct(), realPath))));
        req.setAttribute("isSuccessful",isSuccessful);
        req.setAttribute("orderId", orderId);
        req.setAttribute("ordersHistory", orders);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}