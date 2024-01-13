package com.webteam.laptopmall.orderitem;

import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.util.CurrencyUtil;

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

    public BigDecimal totalDiscountedOfCartItem(){
        return this.totalOriginalOfCartItem().subtract(this.totalDiscountOfCartItem());
    }

    public BigDecimal totalOriginalOfCartItem(){
        return this.product.getPrice().multiply(new BigDecimal(this.qty));
    }

    public BigDecimal totalDiscountOfCartItem(){
        return this.product.getDiscountPrice().multiply(new BigDecimal(this.qty));
    }

    public String getCurrPiceCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.curPrice);
    }
    public String totalDiscountedOfCartItemCurrentFormat(){
        return CurrencyUtil.getVNFormat(this.totalDiscountedOfCartItem());
    }
    public String totalOriginalOfCartItemCurrentFormat(){
        return CurrencyUtil.getVNFormat(this.totalOriginalOfCartItem());
    }
    public String totalDiscountOfCartItemCurrentFormat(){
        return CurrencyUtil.getVNFormat(this.totalDiscountOfCartItem());
    }
}
