package com.webteam.laptopmall.builder.dto.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.ProductDTO;

import java.math.BigDecimal;

public interface ProductDTOBuilder<R extends ProductDTO> {
    ProductDTOBuilder<R> brand(String brand);

    ProductDTOBuilder<R> model(String model);

    ProductDTOBuilder<R> desc(String desc);

    ProductDTOBuilder<R> price(BigDecimal price);

    ProductDTOBuilder<R> stockQty(Integer stockQty);

    ProductDTOBuilder<R> discountPercent(double discountPercent);

    ProductDTOBuilder<R> version(String version);

    ProductDTOBuilder<R> color(String color);

    ProductDTOBuilder<R> category(ECategory category);

    ProductDTOBuilder<R> releaseYear(int releaseYear);

    R build();
}
