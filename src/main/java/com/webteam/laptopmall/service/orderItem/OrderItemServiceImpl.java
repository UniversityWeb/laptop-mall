package com.webteam.laptopmall.service.orderItem;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.OrderItem;
import com.webteam.laptopmall.mapper.OrderItemMapper;
import com.webteam.laptopmall.repository.orderItem.OrderItemRepos;

public class OrderItemServiceImpl implements OrderItemService{
    private OrderItemRepos orderItemRepos;
    private OrderItemMapper orderItemMapper;

    @Override
    public void save(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
        orderItemRepos.save(orderItem);
    }
}
