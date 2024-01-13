package com.webteam.laptopmall.cart.controller;

import com.webteam.laptopmall.cartitem.CartItemDTO;
import com.webteam.laptopmall.order.OrderDTO;
import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.payment.Payment;
import com.webteam.laptopmall.cart.service.CartService;
import com.webteam.laptopmall.cart.service.CartServiceImpl;
import com.webteam.laptopmall.order.service.OrderService;
import com.webteam.laptopmall.order.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    private OrderService orderService;
    private CartService cartService;
    private static final Logger logger = Logger.getLogger(PaymentServlet.class.getName());

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        cartService = new CartServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/send-voice";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        List<CartItemDTO> cart = cartService.getCartByUserId(order.getCustomer().getId());
        String paymentMethod = req.getParameter("paymentMethod");

        if(paymentMethod == null){
            logger.info("Delivery method is empty");
            url = "/payment-method?error=True";
        }
        else{
            orderService.setOrderItemByCart(order, cart);
            order.setOrderDate(new Date());
            order.setPayment(new Payment(Payment.EMethod.valueOf(paymentMethod), Payment.EStatus.PENDING));
            order.setStatus(Order.EStatus.PENDING);
            order = orderService.saveOrderAndDeleteCart(order, cart);
            session.setAttribute("customer", null);
        }

        session.setAttribute("order", order);
        resp.sendRedirect(req.getContextPath() + url);
    }
}
