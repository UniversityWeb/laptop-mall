package com.webteam.laptopmall.cart.controller;

import com.webteam.laptopmall.order.OrderDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check-infor-delivery")
public class CheckDeliveryInforServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(CheckDeliveryInforServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/payment-method";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        String deliveryMethod = req.getParameter("deliveryMethod");
        String note = req.getParameter("note");

        order.setDeliveryMethod(deliveryMethod);
        order.setNote(note);

        if(order.getDeliveryMethod() == null){
            log.info("Delivery is empty");
            url = "/delivery-infor?error=True";
        }

        session.setAttribute("order", order);
        resp.sendRedirect(req.getContextPath() + url);
    }
}
