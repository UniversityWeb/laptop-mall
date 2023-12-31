package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ProductMapper.class)
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
    @Named("toOrderItemDTO")
    OrderItemDTO toDTO(OrderItem entity);

    @Named("toOrderItem")
    OrderItem toEntity(OrderItemDTO dto);
}
