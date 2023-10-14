package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CategoryDTO;
import com.webteam.laptopmall.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Named("toCategoryDTO")
    CategoryDTO toDTO(Category entity);

    @Named("toCategory")
    Category toEntity(CategoryDTO dto);
}
