package com.webteam.laptopmall.dto;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.utility.CurrencyUtil;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

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

    public BigDecimal totalDiscountedAmountOfCartItem() {
        BigDecimal totalOriginalAmount = this.totalOriginalAmountOfCartItem();
        BigDecimal totalDiscountAmount = this.totalDiscountAmountOfCartItem();
        return totalOriginalAmount.subtract(totalDiscountAmount);
    }

    public BigDecimal totalOriginalAmountOfCartItem() {
        BigDecimal pricePerUnit = this.getProduct().getPrice();
        Integer quantity = this.getQty();
        return pricePerUnit.multiply(new BigDecimal(quantity));
    }

    public BigDecimal totalDiscountAmountOfCartItem() {
        Double discountPercent = this.getProduct().getDiscountPercent();
        BigDecimal totalOriginalAmount = this.totalOriginalAmountOfCartItem();
        if (discountPercent == null || discountPercent<=0)
            return new BigDecimal(0);
        return totalOriginalAmount.divide(new BigDecimal(100)).multiply(new BigDecimal(discountPercent));
    }

    public String totalDiscountedAmountOfCartItemCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.totalDiscountedAmountOfCartItem());
    }

    public String totalOriginalAmountOfCartItemCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.totalOriginalAmountOfCartItem());
    }

    public String totalDiscountAmountOfCartItemCurrentFormat() {
        return CurrencyUtil.getVNFormat((this.totalDiscountAmountOfCartItem()));
    }
}
