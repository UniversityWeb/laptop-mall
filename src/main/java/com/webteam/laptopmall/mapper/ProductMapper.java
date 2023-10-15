package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.ProductDTO;
import com.webteam.laptopmall.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Named("toProductDTO")
    ProductDTO toDTO(Product product);

    @Named("toProduct")
    Product toEntity(ProductDTO productDTO);
}
