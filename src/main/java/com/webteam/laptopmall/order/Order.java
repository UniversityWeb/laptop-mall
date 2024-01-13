package com.webteam.laptopmall.order;

import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.orderitem.OrderItem;
import com.webteam.laptopmall.payment.Payment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    public enum EStatus {
        /**
         * The order is pending and has not yet been processed.
         */
        PENDING,

        /**
         * The order is being processed for shipment.
         */
        PROCESSING,

        /**
         * The order has been shipped.
         */
        SHIPPED,

        /**
         * The order has been delivered to the customer.
         */
        DELIVERED,

        /**
         * The order has been cancelled, either by the customer or the seller.
         */
        CANCELLED,

        /**
         * The order has been returned by the customer for various reasons.
         */
        RETURNED,

        /**
         * The payment for the order has been refunded to the customer.
         */
        REFUNDED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "delivery_method")
    private String deliveryMethod;

    @Enumerated(EnumType.STRING)
    private EStatus status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    private String note;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long id, User customer, Date orderDate, String deliveryMethod, EStatus status, Payment payment, String note, List<OrderItem> orderItems) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
        this.payment = payment;
        this.note = note;
        this.orderItems = orderItems;
    }

    public Order(User customer, Date orderDate, String deliveryMethod, EStatus status, Payment payment, String note) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.deliveryMethod = deliveryMethod;
        this.status = status;
        this.payment = payment;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", status=" + status +
                ", payment=" + payment +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
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

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
