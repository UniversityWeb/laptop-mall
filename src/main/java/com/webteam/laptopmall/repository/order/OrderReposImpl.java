package com.webteam.laptopmall.repository.order;

import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

public class OrderReposImpl extends BaseReposImpl<Order, Long> implements OrderRepos {
    @Override
    protected Class<Order> getClassType() {
        return Order.class;
    }
}
