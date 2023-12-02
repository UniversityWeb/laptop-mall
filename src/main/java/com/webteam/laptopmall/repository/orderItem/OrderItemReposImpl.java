package com.webteam.laptopmall.repository.orderItem;

import com.webteam.laptopmall.entity.OrderItem;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

public class OrderItemReposImpl extends BaseReposImpl<OrderItem, Long> implements OrderItemRepos{
    @Override
    protected Class<OrderItem> getClassType() {
        return null;
    }
}
