package com.webteam.laptopmall.service.orderItem;

import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.OrderItem;
import com.webteam.laptopmall.mapper.OrderItemMapper;
import com.webteam.laptopmall.repository.orderItem.OrderItemRepos;
import com.webteam.laptopmall.repository.orderItem.OrderItemReposImpl;

public class OrderItemServiceImpl implements OrderItemService{
    private OrderItemRepos orderItemRepos;

    public OrderItemServiceImpl(){
        orderItemRepos = new OrderItemReposImpl();
    }

    @Override
    public void save(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = OrderItemMapper.INSTANCE.toEntity(orderItemDTO);
        orderItemRepos.save(orderItem);
    }
}
