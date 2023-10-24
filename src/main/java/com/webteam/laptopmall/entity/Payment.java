package com.webteam.laptopmall.entity;

import com.webteam.laptopmall.customenum.EPaymentMethod;
import com.webteam.laptopmall.customenum.EPaymentStatus;

import javax.persistence.*;

@Entity
@Table(name = "payment_details")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
    private Order order;

    private EPaymentMethod paymentMethod;

    private EPaymentStatus status;

    public Payment() {
    }

    public Payment(Long id, Order order, EPaymentMethod paymentMethod, EPaymentStatus status) {
        this.id = id;
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentMethod=" + paymentMethod +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public EPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(EPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public EPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(EPaymentStatus status) {
        this.status = status;
    }
}
