package com.webteam.laptopmall.dto;

import com.webteam.laptopmall.dto.prod.ProductDTO;

import java.math.BigDecimal;

public class OrderItemDTO {
    private Long id;
    private ProductDTO product;
    private int qty;
    private BigDecimal curPrice;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, ProductDTO product, int qty, BigDecimal curPrice) {
        this.id = id;
        this.product = product;
        this.qty = qty;
        this.curPrice = curPrice;
    }

    public OrderItemDTO(ProductDTO product, int qty, BigDecimal curPrice) {
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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO productDTO) {
        this.product = productDTO;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(BigDecimal curPrice) {
        this.curPrice = curPrice;
    }
}
