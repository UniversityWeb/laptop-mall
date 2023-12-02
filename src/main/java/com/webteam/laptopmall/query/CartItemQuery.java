package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.CartItem;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CartItemQuery {
    public TypedQuery<CartItem> buildUpdateQtyOnly(EntityManager em, Long cartItemId, int newQty) {
        String sqlStr = "UPDATE CartItem ci SET ci.qty = :newQty WHERE ci.id = :cartItemId";
        TypedQuery<CartItem> typedQuery = em.createQuery(sqlStr, CartItem.class);
        typedQuery.setParameter("cartItemId", cartItemId);
        typedQuery.setParameter("newQty", newQty);
        return typedQuery;
    }
}
