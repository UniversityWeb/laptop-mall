package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.entity.Payment;
import com.webteam.laptopmall.service.order.OrderService;
import com.webteam.laptopmall.service.order.OrderServiceImpl;

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

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
    }

    private static final Logger logger = Logger.getLogger(PaymentServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/send-voice";
        String message = "";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
        String paymentMethod = req.getParameter("paymentMethod");

        if(paymentMethod == null){
            message = "Please choose delivery method!";
            logger.info("Delivery method is empty");
            url = "/payment-method?error=True";
        }
        else{
            orderService.setOrderItemByCart(order, cart);
            order.setOrderDate(new Date());
            order.setPayment(new Payment(Payment.EMethod.valueOf(paymentMethod), Payment.EStatus.PENDING));
        }

        session.setAttribute("order", order);
        resp.sendRedirect(req.getContextPath() + url);
    }
}
