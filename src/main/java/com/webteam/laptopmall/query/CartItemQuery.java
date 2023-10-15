package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.CartItem;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CartItemQuery {
    public TypedQuery<CartItem> buildUpdateQtyOnly(EntityManager em, Long userId, int newQty) {
        String sqlStr = "UPDATE CartItem ci SET ci.qty = :newQty WHERE ci.customer.id = :userId";
        TypedQuery<CartItem> typedQuery = em.createQuery(sqlStr, CartItem.class);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("newQty", newQty);
        return typedQuery;
    }

    public TypedQuery<CartItem> buildGetByUserId(EntityManager em, Long userId) {
        String sqlStr = "SELECT ci FROM CartItem ci WHERE ci.customer.id = :userId";
        TypedQuery<CartItem> typedQuery = em.createQuery(sqlStr, CartItem.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery;
    }
}
