package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.entity.Payment;
import com.webteam.laptopmall.service.order.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    private OrderService orderService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = "/send-voice";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");

        if(order == null || cart == null){
            url = "/method-delivery";
        }
        else{
            String paymentMethod = req.getParameter("paymentMethod");
            orderService.setOrderItemByCart(order, cart);
            order.setOrderDate(new Date());
            order.setPayment(new Payment(Payment.EMethod.valueOf(paymentMethod), Payment.EStatus.PENDING));
            session.setAttribute("cart", null);
        }

        session.setAttribute("order", order);
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
