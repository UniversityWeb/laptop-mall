package com.webteam.laptopmall.repository.order;

import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.List;

public interface OrderRepos extends BaseRepos<Order, Long> {
    Order update(Order order);
    List<Order> getListByUserIdAndStatus(Long userId, Order.EStatus status);
    List<Order> getListByUserId(Long userId);
    Order getByUserAndOrderId(Long userId, Long orderId);
}
