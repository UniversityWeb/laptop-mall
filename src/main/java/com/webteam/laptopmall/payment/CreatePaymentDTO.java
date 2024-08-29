package com.webteam.laptopmall.payment;

import com.webteam.laptopmall.order.OrderDTO;

public class CreatePaymentDTO {
    private OrderDTO order;
    private String paymentUrl;

    public CreatePaymentDTO(OrderDTO order, String paymentUrl) {
        this.order = order;
        this.paymentUrl = paymentUrl;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }
}
