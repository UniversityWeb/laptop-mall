package com.webteam.laptopmall.repository.cartitem;

import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.query.CartItemQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartItemReposImpl extends BaseReposImpl<CartItem, Long> implements CartItemRepos {

    private final Logger log = Logger.getLogger(CartItemReposImpl.class.getName());

    private CartItemQuery ciQuery;

    public CartItemReposImpl() {
        super();
        ciQuery = new CartItemQuery();
    }

    @Override
    protected Class<CartItem> getClassType() {
        return CartItem.class;
    }

    @Override
    public boolean updateQtyOnly(Long userId, int newQty) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int updatedEntities = 0;
        try {
            trans.begin();
            TypedQuery<CartItem> typedQuery = ciQuery.buildUpdateQtyOnly(em, userId, newQty);
            updatedEntities = typedQuery.executeUpdate();
            trans.commit();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return updatedEntities > 0;
    }

    @Override
    public List<CartItem> getByUserId(Long userId) {
//        return getResultList(em -> ciQuery.buildGetByUserId(em, userId));
        return null;
    }
}
