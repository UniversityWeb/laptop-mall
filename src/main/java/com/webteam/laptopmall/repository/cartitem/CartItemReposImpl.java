package com.webteam.laptopmall.repository.cartitem;

import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.query.CartItemQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
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
            dbCon.closeEm(em);
        }
        return updatedEntities > 0;
    }

    @Override
    public List<CartItem> getByUserId(Long userId) {
        EntityManager em = emf.createEntityManager();
        List<CartItem> items = new ArrayList<>();
        try {
            TypedQuery<CartItem> typedQuery = ciQuery.buildGetByUserId(em, userId);
            items = typedQuery.getResultList();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, e.getMessage());
        } finally {
            dbCon.closeEm(em);
        }
        return items;
    }
}
