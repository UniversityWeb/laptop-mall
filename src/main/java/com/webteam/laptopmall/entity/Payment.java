package com.webteam.laptopmall.entity;

import javax.persistence.*;

@Entity
@Table(name = "payment_details")
public class Payment {
    public enum EMethod {
        CASH_ON_DELIVERY, MOMO, VN_PAY
    }

    public enum EStatus {
        PENDING, AUTHORIZED, FAILED, REFUNDED, CHANGE_BACK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private EStatus status;

    public Payment() {
    }

    public Payment(EMethod paymentMethod, EStatus status) {
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

    public EMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(EMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }
}
