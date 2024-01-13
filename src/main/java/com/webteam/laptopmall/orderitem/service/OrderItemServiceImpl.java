package com.webteam.laptopmall.orderitem.service;

import com.webteam.laptopmall.orderitem.OrderItemDTO;
import com.webteam.laptopmall.orderitem.OrderItem;
import com.webteam.laptopmall.orderitem.OrderItemMapper;
import com.webteam.laptopmall.orderitem.repos.OrderItemRepos;
import com.webteam.laptopmall.orderitem.repos.OrderItemReposImpl;

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
