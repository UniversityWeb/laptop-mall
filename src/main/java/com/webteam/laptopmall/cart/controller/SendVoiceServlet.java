package com.webteam.laptopmall.cart.controller;

import com.webteam.laptopmall.order.OrderDTO;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.order.service.OrderService;
import com.webteam.laptopmall.order.service.OrderServiceImpl;
import com.webteam.laptopmall.util.MailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/send-voice")
public class SendVoiceServlet extends HttpServlet {
    private OrderService orderService;
    private ProdImgIO prodImgIO;
    private static final Logger logger = Logger.getLogger(PaymentServlet.class.getName());

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
        String url = "/success-delivery";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");

        String to = order.getCustomer().getEmail();
        String from = "vanantran009@gmail.com";
        String subject = "Your Invoice";

        String realPath = req.getServletContext().getRealPath("/");
        order.getOrderItems().forEach(orderItem -> orderItem.setProduct(prodImgIO.loadProdImageUrls(orderItem.getProduct(), realPath)));

        String body = orderService.getMailBody(order);

        System.out.println(order.getCustomer().getEmail());

        try{
            MailUtil.sendMail(to, from, subject, body);
            session.setAttribute("order", null);
        }catch (MessagingException e){
            String errorMessage = "ERROR: Unable to send email." +
                    "Check Tomcat logs for details.< br>" +
                    "ERROR MESSAGE: " + e.getMessage();
            logger.severe(errorMessage);
            url = "/method-delivery";
        }
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
