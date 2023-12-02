package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Named("toOrderDTO")
    OrderDTO toDTO(Order entity);

    @Named("toOrder")
    Order toEntity(OrderDTO dto);
}
