package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CategoryDTO;
import com.webteam.laptopmall.entity.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryMapperTest {
    @Test
    void testToDTO() {
        Category category = new Category(1, "Laptop");
        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.toDTO(category);

        assertEquals(category.getId(), categoryDTO.getId());
        assertEquals(category.getName(), categoryDTO.getName());
    }

    @Test
    void testToEntity() {
        CategoryDTO categoryDTO = new CategoryDTO(1, "Laptop");
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);

        assertEquals(categoryDTO.getId(), category.getId());
        assertEquals(categoryDTO.getName(), category.getName());
    }
}