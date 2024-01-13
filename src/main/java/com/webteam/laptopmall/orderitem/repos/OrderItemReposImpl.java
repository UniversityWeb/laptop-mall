package com.webteam.laptopmall.orderitem.repos;

import com.webteam.laptopmall.orderitem.OrderItem;
import com.webteam.laptopmall.infrastructure.repository.BaseReposImpl;

public class OrderItemReposImpl extends BaseReposImpl<OrderItem, Long> implements OrderItemRepos{
    @Override
    protected Class<OrderItem> getClassType() {
        return null;
    }
}
