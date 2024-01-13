package com.webteam.laptopmall.order.repos;

import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.product.entity.Product;
import com.webteam.laptopmall.infrastructure.repository.BaseRepos;

import java.util.List;

public interface OrderRepos extends BaseRepos<Order, Long> {
    Order update(Order order);
    List<Order> getListByUserIdAndStatus(Long userId, Order.EStatus status);
    List<Order> getListByUserId(Long userId);
    Order getByUserAndOrderId(Long userId, Long orderId);
    List<Order> getListByStatusAndTime(Order.EStatus status, Integer month, Integer year);

    List<Order> getListByTime(Integer month, Integer year);

    void getDataProductDESCByTime(List<Product> products, List<Integer> qtys, Integer month, Integer year);

    void getDataProductASCByTime(List<Product> products, List<Integer> qtys, Integer month, Integer year);

    List<Order> getOrdersContainProdID(Long prodID);
}
