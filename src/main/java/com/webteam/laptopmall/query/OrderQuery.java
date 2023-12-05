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

    public TypedQuery<Order> buildGetListGetByUserId(EntityManager em, Long userId) {
        String sqlStr = "SELECT od FROM Order od WHERE od.customer.id = :userId";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery;
    }

    public TypedQuery<Order> buildGetByUserAndOrderId(EntityManager em, Long userId, Long orderId) {
        String sqlStr = "SELECT od FROM Order od " +
                "WHERE od.customer.id = :userId and od.id = :orderId";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("orderId", orderId);
        return typedQuery;
    }

    public TypedQuery<Order> buildGetListByStatusAndTime(EntityManager em, Order.EStatus status, Integer month, Integer year) {
        String sqlStr = "SELECT od FROM Order od WHERE od.status= :status " +
                "and MONTH(od.orderDate) = :month " +
                "and YEAR(od.orderDate) = :year";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setParameter("status", status);
        typedQuery.setParameter("month", month);
        typedQuery.setParameter("year", year);
        return typedQuery;
    }

    public TypedQuery<Order> buildGetListByTime(EntityManager em, Integer month, Integer year) {
        String sqlStr = "SELECT o FROM Order o WHERE YEAR(o.orderDate) = :year AND MONTH(o.orderDate) = :month";
        TypedQuery<Order> typedQuery = em.createQuery(sqlStr, Order.class);
        typedQuery.setMaxResults(10);
        typedQuery.setParameter("month", month);
        typedQuery.setParameter("year", year);
        return typedQuery;
    }

    public TypedQuery<Object[]> buildGetDataProductDESCByTime(EntityManager em, Integer month, Integer year) {
        String sqlStr = "SELECT oi.product, SUM(oi.qty) as totalQty " +
                        "FROM Order o " +
                        "JOIN o.orderItems oi " +
                        "WHERE YEAR(o.orderDate) = :year AND MONTH(o.orderDate) = :month " +
                        "GROUP BY oi.product " +
                        "ORDER BY totalQty DESC";
        TypedQuery<Object[]> typedQuery = em.createQuery(sqlStr, Object[].class);
        typedQuery.setMaxResults(10);
        typedQuery.setParameter("month", month);
        typedQuery.setParameter("year", year);
        return typedQuery;
    }

    public TypedQuery<Object[]> buildGetDataProductASCByTime(EntityManager em, Integer month, Integer year) {
        String sqlStr = "SELECT oi.product, SUM(oi.qty) as totalQty " +
                "FROM Order o " +
                "JOIN o.orderItems oi " +
                "WHERE YEAR(o.orderDate) = :year AND MONTH(o.orderDate) = :month " +
                "GROUP BY oi.product " +
                "ORDER BY totalQty ASC";
        TypedQuery<Object[]> typedQuery = em.createQuery(sqlStr, Object[].class);
        typedQuery.setMaxResults(10);
        typedQuery.setParameter("month", month);
        typedQuery.setParameter("year", year);
        return typedQuery;
    }
}
