package com.webteam.laptopmall.cartitem;

import com.webteam.laptopmall.cartitem.CartItem;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CartItemQuery {
    public Query buildUpdateQtyOnly(EntityManager em, Long cartItemId, int newQty) {
        String sqlStr = "UPDATE CartItem ci SET ci.qty = :newQty WHERE ci.id = :cartItemId";
        Query query = em.createQuery(sqlStr);
        query.setParameter("cartItemId", cartItemId);
        query.setParameter("newQty", newQty);
        return query;
    }

    public TypedQuery<CartItem> buildGetListByUserId(EntityManager em, Long userId) {
        String sqlStr = "SELECT ci FROM CartItem ci WHERE ci.customer.id = :userid";
        TypedQuery<CartItem> typedQuery = em.createQuery(sqlStr, CartItem.class);
        typedQuery.setParameter("userid", userId);
        return typedQuery;
    }

    public TypedQuery<CartItem> buildGetByUserAndProductId(EntityManager em, Long userId, Long productId) {
        String sqlStr = "SELECT ci FROM CartItem ci WHERE ci.customer.id = :userid and ci.product.id = :productId";
        TypedQuery<CartItem> typedQuery = em.createQuery(sqlStr, CartItem.class);
        typedQuery.setParameter("userid", userId);
        typedQuery.setParameter("productId", productId);
        return typedQuery;
    }
}
