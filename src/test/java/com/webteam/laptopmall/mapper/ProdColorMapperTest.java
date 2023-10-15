package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.ProdColorDTO;
import com.webteam.laptopmall.entity.ProdColor;
import com.webteam.laptopmall.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdColorMapperTest {
    @Test
    void testToDTO() {
        ProdColor prodColor = new ProdColor(1, "Green", new Product());
        ProdColorDTO prodColorDTO = ProdColorMapper.INSTANCE.toDTO(prodColor);

        assertEquals(prodColor.getId(), prodColorDTO.getId());
        assertEquals(prodColor.getName(), prodColorDTO.getName());
    }

    @Test
    void testToEntity() {
        ProdColorDTO prodColorDTO = new ProdColorDTO(1, "Green", new Product());
        ProdColor category = ProdColorMapper.INSTANCE.toEntity(prodColorDTO);

        assertEquals(prodColorDTO.getId(), category.getId());
        assertEquals(prodColorDTO.getName(), category.getName());
    }
}