package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class OrderQuery {
    public TypedQuery<Order> buildGetListByUserIdAndStatus(EntityManager em, Long userId, Order.EStatus status) {
        String sqlStr = "SELECT od FROM Order od WHERE od.status = :status and od.customer.id = :userId";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setParameter("status", status);
        typedQuery.setParameter("userId", userId);
        return typedQuery;
    }

    public TypedQuery<Order> buildListGetByUserId(EntityManager em, Long userId) {
        String sqlStr = "SELECT od FROM Order od WHERE od.customer.id = :userId";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery;
    }

    public TypedQuery<Order> getByUserAndOrderId(EntityManager em, Long userId, Long orderId) {
        String sqlStr = "SELECT od FROM Order od WHERE od.customer.id = :userId and od.id = :orderId";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("orderId", orderId);
        return typedQuery;
    }
}
