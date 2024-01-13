package com.webteam.laptopmall.orderitem;

import com.webteam.laptopmall.product.entity.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer qty;

    @Column(name = "cur_price")
    private BigDecimal curPrice;

    public OrderItem() {
    }

    public OrderItem(Long id, Product product, Integer qty, BigDecimal curPrice) {
        this.id = id;
        this.product = product;
        this.qty = qty;
        this.curPrice = curPrice;
    }

    public OrderItem(Product product, Integer qty, BigDecimal curPrice) {
        this.product = product;
        this.qty = qty;
        this.curPrice = curPrice;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(BigDecimal curPrice) {
        this.curPrice = curPrice;
    }
}
