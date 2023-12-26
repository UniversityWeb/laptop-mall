package com.webteam.laptopmall.servlet.seller;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
import com.webteam.laptopmall.service.order.OrderService;
import com.webteam.laptopmall.service.order.OrderServiceImpl;
import com.webteam.laptopmall.service.user.UserService;
import com.webteam.laptopmall.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/seller-order-details")
public class OrderDetailsServlet extends HttpServlet {
    private OrderService orderService;
    private UserService userService;
    private ProdImgIO prodImgIO;
    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/seller-order-details.jsp";

        Long userId =Long.valueOf(req.getParameter("userId")) ;
        Long orderId = Long.valueOf(req.getParameter("orderId"));
        OrderDTO orderHistory = orderService.getByUserAndOrderId(userId, orderId);
        String realPath = req.getServletContext().getRealPath("/");
        orderHistory.getOrderItems().forEach(orderItem -> orderItem.setProduct(prodImgIO.loadProdImageUrls(orderItem.getProduct(), realPath)));

        req.setAttribute("orderHistory", orderHistory);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
