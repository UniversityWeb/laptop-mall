package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.service.order.OrderService;
import com.webteam.laptopmall.utility.MailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/send-voice")
public class SendVoiceServlet extends HttpServlet {
    private OrderService orderService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = "/WEB-INF/views/cart/success-delivery.jsp";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");

        String to = order.getCustomer().getEmail();
        String from = "vanantran009@gmail.com";
        String subject = "Your Invoice";
        String body = orderService.getMailBody(order);

        System.out.println(order.getCustomer().getEmail());

        try{
            MailUtil.sendMail(to, from, subject, body);
            session.setAttribute("order", null);
        }catch (MessagingException e){
            String errorMessage = "ERROR: Unable to send email." +
                    "Check Tomcat logs for details.< br>" +
                    "ERROR MESSAGE: " + e.getMessage();
            System.out.println(errorMessage);
            url = "/method-delivery";
        }
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}