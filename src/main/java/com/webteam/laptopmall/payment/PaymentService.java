package com.webteam.laptopmall.payment;

import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.order.OrderDTO;
import com.webteam.laptopmall.order.service.OrderService;
import com.webteam.laptopmall.order.service.OrderServiceImpl;
import com.webteam.laptopmall.payment.vnpay.VNPayService;

import javax.servlet.http.HttpServletRequest;

public class PaymentService {

    private final OrderService orderService;
    private final VNPayService vnpayService;

    public PaymentService() {
        orderService = new OrderServiceImpl();
        vnpayService = new VNPayService();
    }

    public CreatePaymentDTO createOrder(Payment.EMethod paymentMethod, HttpServletRequest req, OrderDTO order, String urlReturn) {
        String url;
        Long orderId = order.getId();
        int totalPrice = (int) Math.round( orderService.getTotalPrice( orderId ) );
        switch (paymentMethod) {
            case CASH_ON_DELIVERY:
                url = "/send-voice";
                break;
            case MOMO:
                url = "/payment-method?error=True";
                break;
            case VN_PAY:
                url = vnpayService.createOrder(req, totalPrice, order.getId().toString(), urlReturn);
                break;
            default:
                url = "/payment-method?error=True";
                break;
        }
        return new CreatePaymentDTO(order, url);
    }
}
