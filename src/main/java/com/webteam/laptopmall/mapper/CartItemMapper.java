package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    @Named("toCartItemDTO")
    CartItemDTO toDTO(CartItem entity);

    @Named("toCartItem")
    CartItem toEntity(CartItemDTO dto);
}
