package com.webteam.laptopmall.product.builder.dto.prod;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.ProductDTO;

import java.math.BigDecimal;

public interface ProductDTOBuilder<R extends ProductDTO> {
    ProductDTOBuilder<R> id(Long id);
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
