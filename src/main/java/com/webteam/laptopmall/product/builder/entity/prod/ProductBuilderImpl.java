package com.webteam.laptopmall.product.builder.entity.prod;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.entity.Product;

import java.math.BigDecimal;

public abstract class ProductBuilderImpl<R extends Product> implements ProductBuilder<R> {
    protected R prod;

    protected ProductBuilderImpl() {
    }

    @Override
    public ProductBuilder<R> id(Long id) {
        prod.setId(id);
        return this;
    }

    @Override
    public ProductBuilder<R> brand(String brand) {
        prod.setBrand(brand);
        return this;
    }

    @Override
    public ProductBuilder<R> model(String model) {
        prod.setModel(model);
        return this;
    }

    @Override
    public ProductBuilder<R> desc(String desc) {
        prod.setDesc(desc);
        return this;
    }

    @Override
    public ProductBuilder<R> price(BigDecimal price) {
        prod.setPrice(price);
        return this;
    }

    @Override
    public ProductBuilder<R> stockQty(Integer stockQty) {
        prod.setStockQty(stockQty);
        return this;
    }

    @Override
    public ProductBuilder<R> discountPercent(double discountPercent) {
        prod.setDiscountPercent(discountPercent);
        return this;
    }

    @Override
    public ProductBuilder<R> version(String version) {
        prod.setVersion(version);
        return this;
    }

    @Override
    public ProductBuilder<R> color(String color) {
        prod.setColor(color);
        return this;
    }

    @Override
    public ProductBuilder<R> category(ECategory category) {
        prod.setCategory(category);
        return this;
    }

    @Override
    public ProductBuilder<R> releaseYear(int releaseYear) {
        prod.setReleaseYear(releaseYear);
        return this;
    }

    @Override
    public abstract R build();
}
