package com.webteam.laptopmall.dto.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.utility.CurrencyUtil;

import java.math.BigDecimal;

public abstract class ProductDTO {
    protected Long id;
    protected String brand;
    protected String model;
    protected String desc;
    protected BigDecimal price;
    protected Integer stockQty;
    protected double discountPercent;
    protected String version;
    protected String color;
    protected int releaseYear;
    protected ECategory category;

    protected ProductDTO() {
    }

    protected ProductDTO(Long id, String brand, String model, String desc, BigDecimal price, Integer stockQty,
                      double discountPercent, String version, String color, int releaseYear,ECategory category) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.desc = desc;
        this.price = price;
        this.stockQty = stockQty;
        this.discountPercent = discountPercent;
        this.version = version;
        this.color = color;
        this.releaseYear = releaseYear;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                ", discountPercent=" + discountPercent +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", category=" + category +
                '}';
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public BigDecimal priceDiscount(){
        return this.price.multiply(new BigDecimal(this.discountPercent)).divide(new BigDecimal(100));
    }
    public BigDecimal priceDiscounted(){
        return this.price.subtract(this.priceDiscount());
    }

    public String priceCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.price);
    }
    public String priceDiscountCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.priceDiscount());
    }
    public String priceDiscountedCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.priceDiscounted());
    }
}
