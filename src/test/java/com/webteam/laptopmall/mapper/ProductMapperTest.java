package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CategoryDTO;
import com.webteam.laptopmall.dto.ProductDTO;
import com.webteam.laptopmall.entity.Category;
import com.webteam.laptopmall.entity.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    @Test
    void testToDTO() {
        Product product = new Product(1L, "Brand", "Model", "Description", new BigDecimal("1000.00"),
                10, "image.jpg", new Category(1, "Laptop"));
        ProductDTO productDTO = ProductMapper.INSTANCE.toDTO(product);

        assertEquals(product.getId(), productDTO.getId());
        assertEquals(product.getBrand(), productDTO.getBrand());
        assertEquals(product.getModel(), productDTO.getModel());
        assertEquals(product.getDesc(), productDTO.getDesc());
        assertEquals(product.getPrice(), productDTO.getPrice());
        assertEquals(product.getStockQty(), productDTO.getStockQty());
        assertEquals(product.getImgUrl(), productDTO.getImgUrl());
    }

    @Test
    void testToEntity() {
        ProductDTO productDTO = new ProductDTO(1L, "Brand", "Model", "Description", new BigDecimal("1000.00"),
                10, "image.jpg", new CategoryDTO(1, "Laptop"));
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);

        assertEquals(productDTO.getId(), product.getId());
        assertEquals(productDTO.getBrand(), product.getBrand());
        assertEquals(productDTO.getModel(), product.getModel());
        assertEquals(productDTO.getDesc(), product.getDesc());
        assertEquals(productDTO.getPrice(), product.getPrice());
        assertEquals(productDTO.getStockQty(), product.getStockQty());
        assertEquals(productDTO.getImgUrl(), product.getImgUrl());
    }
}