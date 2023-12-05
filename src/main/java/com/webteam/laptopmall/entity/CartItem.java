package com.webteam.laptopmall.entity;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.entity.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CartItem() {
    }

    public CartItem(Long id, Integer qty, User customer, Product product) {
        this.id = id;
        this.qty = qty;
        this.customer = customer;
        this.product = product;
    }

    public CartItem(Integer qty, User customer, Product product) {
        this.qty = qty;
        this.customer = customer;
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", qty=" + qty +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
