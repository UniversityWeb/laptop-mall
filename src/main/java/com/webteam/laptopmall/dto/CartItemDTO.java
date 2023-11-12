package com.webteam.laptopmall.dto;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.dto.user.UserDTO;

public class CartItemDTO {
    private Long id;
    private Integer qty;
    private UserDTO customer;
    private ProductDTO product;

    public CartItemDTO() {
    }

    public CartItemDTO(Long id, Integer qty, UserDTO customer, ProductDTO product) {
        this.id = id;
        this.qty = qty;
        this.customer = customer;
        this.product = product;
    }

    public CartItemDTO(Integer qty, UserDTO customer, ProductDTO product) {
        this.qty = qty;
        this.customer = customer;
        this.product = product;
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

    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
