package com.webteam.laptopmall.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String brand;
    private String model;
    private String desc;
    private BigDecimal price;
    private Integer stockQty;
    private double discountPercent;
    private String version;
    private String color;
    private CategoryDTO category;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String brand, String model, String desc, BigDecimal price, Integer stockQty,
                      double discountPercent, String version, String color, CategoryDTO category) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.desc = desc;
        this.price = price;
        this.stockQty = stockQty;
        this.discountPercent = discountPercent;
        this.version = version;
        this.color = color;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
