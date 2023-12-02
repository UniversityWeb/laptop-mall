package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/check-infor-delivery")
public class CheckDeliveryInforServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CheckDeliveryInforServlet.class.getName());

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
            logger.severe("Delivery is empty");
            url = "/delivery-infor?error=True";
        }

        session.setAttribute("order", order);
        resp.sendRedirect(req.getContextPath() + url);
    }
}
