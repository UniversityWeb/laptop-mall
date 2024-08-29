package com.webteam.laptopmall.payment;

import com.webteam.laptopmall.payment.vnpay.VNPayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vnpay-payment")
public class VNPaymentServlet extends HttpServlet {

    private final static Logger log = LogManager.getLogger(VNPaymentServlet.class);

    private VNPayService vnPayService;

    @Override
    public void init() throws ServletException {
        super.init();
        vnPayService = new VNPayService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to '/vnpay-payment' (Get method)");
        log.info("Context path: " + getServletContext().getContextPath());

        int paymentStatus = vnPayService.orderReturn(req);

        String orderInfo = req.getParameter("vnp_OrderInfo");
        String paymentTime = req.getParameter("vnp_PayDate");
        String transactionId = req.getParameter("vnp_TransactionNo");
        String totalPrice = req.getParameter("vnp_Amount");

        req.setAttribute("orderId", orderInfo);
        req.setAttribute("totalPrice", totalPrice);
        req.setAttribute("paymentTime", paymentTime);
        req.setAttribute("transactionId", transactionId);

        String url;
        if (paymentStatus == 1) {
            url = "/ordersuccess.jsp";
        } else {
            url = "/orderfail.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to '/vnpay-payment' (Post method)");
        log.info("Context path: " + getServletContext().getContextPath());

        String orderTotalStr = req.getParameter("amount");
        int orderTotal = Integer.parseInt(orderTotalStr);
        String orderInfo = req.getParameter("orderInfo");

        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int port = req.getServerPort();
        String contextPath = req.getContextPath();

        String baseUrl = String.format("%s://%s:%s%s", scheme, serverName, port, contextPath);
        log.info("Base url for return url: " + baseUrl);
        String vnpayUrl = vnPayService.createOrder(req, orderTotal, orderInfo, baseUrl);

        resp.sendRedirect(vnpayUrl);
    }
}
