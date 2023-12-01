package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.servlet.cart.crud.UpdateItemServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/check-infor-delivery")
public class CheckInforDeliveryServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CheckInforDeliveryServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/method-delivery";
        String message = "";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");

        String deliveryMethod = req.getParameter("deliveryMethod");
        String note = req.getParameter("note");

        order.setDeliveryMethod(deliveryMethod);
        order.setNote(note);

        if(order.getDeliveryMethod().equals("") || order.getDeliveryMethod().equals(null)){
            message = "Please choose delivery method";
            logger.severe("Delivery is empty");
            url = "/WEB-INF/views/cart/shipping-infor.jsp";
        }

        req.setAttribute("message", message);
        session.setAttribute("order", order);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
