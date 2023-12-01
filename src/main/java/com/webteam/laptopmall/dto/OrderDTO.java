package com.webteam.laptopmall.dto;

import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.entity.Payment;
import com.webteam.laptopmall.utility.CurrencyUtil;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrderDTO {
    private Long id;
    private UserDTO customer;
    private Date orderDate;
    private String deliveryMethod;
    private Order.EStatus status;
    private Payment payment;
    private String note;

    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long id, UserDTO customer, Date orderDate, String deliveryMethod,
                    Order.EStatus status, Payment payment, String note, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
        this.payment = payment;
        this.note = note;
        this.orderItems = orderItems;
    }

    public OrderDTO(Long id, UserDTO customer, Date orderDate, String deliveryMethod,
                    Order.EStatus status, Payment payment, String note) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
        this.payment = payment;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Order.EStatus getStatus() {
        return status;
    }

    public void setStatus(Order.EStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal totalDiscountedAmountOfOrder() {
        BigDecimal totalDiscounted = new BigDecimal(0);
        for (OrderItemDTO orderItemDTO: this.getOrderItems()) {
            totalDiscounted.add(orderItemDTO.getCurPrice());
        }
        return totalDiscounted;
    }

    public String totalDiscountedAmountOfOrderCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.totalDiscountedAmountOfOrder());
    }
}
