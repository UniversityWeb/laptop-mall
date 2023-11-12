package com.webteam.laptopmall.builder.dto.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.ProductDTO;

import java.math.BigDecimal;

public abstract class ProductDTOBuilderImpl<R extends ProductDTO> implements ProductDTOBuilder<R> {
    protected R prod;

    protected ProductDTOBuilderImpl() {
    }

    @Override
    public ProductDTOBuilder<R> id(Long id) {
        prod.setId(id);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> brand(String brand) {
        prod.setBrand(brand);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> model(String model) {
        prod.setModel(model);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> desc(String desc) {
        prod.setDesc(desc);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> price(BigDecimal price) {
        prod.setPrice(price);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> stockQty(Integer stockQty) {
        prod.setStockQty(stockQty);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> discountPercent(double discountPercent) {
        prod.setDiscountPercent(discountPercent);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> version(String version) {
        prod.setVersion(version);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> color(String color) {
        prod.setColor(color);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> category(ECategory category) {
        prod.setCategory(category);
        return this;
    }

    @Override
    public ProductDTOBuilder<R> releaseYear(int releaseYear) {
        prod.setReleaseYear(releaseYear);
        return this;
    }

    @Override
    public abstract R build();
}
