package com.webteam.laptopmall.service.orderItem;

import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.OrderItem;
import com.webteam.laptopmall.mapper.OrderItemMapper;
import com.webteam.laptopmall.mapper.OrderItemMapperImpl;
import com.webteam.laptopmall.repository.orderItem.OrderItemRepos;
import com.webteam.laptopmall.repository.orderItem.OrderItemReposImpl;

public class OrderItemServiceImpl implements OrderItemService{
    private OrderItemRepos orderItemRepos;
    private OrderItemMapper orderItemMapper;

    public OrderItemServiceImpl(){
        orderItemRepos = new OrderItemReposImpl();
        orderItemMapper = new OrderItemMapperImpl();
    }

    @Override
    public void save(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
        orderItemRepos.save(orderItem);
    }
}
