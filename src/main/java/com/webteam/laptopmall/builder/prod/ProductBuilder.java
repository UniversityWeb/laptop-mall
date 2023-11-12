package com.webteam.laptopmall.builder.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.prod.Product;

import java.math.BigDecimal;

public interface ProductBuilder<R extends Product> {
    ProductBuilder<R> brand(String brand);

    ProductBuilder<R> model(String model);

    ProductBuilder<R> desc(String desc);

    ProductBuilder<R> price(BigDecimal price);

    ProductBuilder<R> stockQty(Integer stockQty);

    ProductBuilder<R> discountPercent(double discountPercent);

    ProductBuilder<R> version(String version);

    ProductBuilder<R> color(String color);

    ProductBuilder<R> category(ECategory category);

    ProductBuilder<R> releaseYear(int releaseYear);

    R build();
}
