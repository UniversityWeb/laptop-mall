package com.webteam.laptopmall.orderitem;

import com.webteam.laptopmall.product.ProductMapper;
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
