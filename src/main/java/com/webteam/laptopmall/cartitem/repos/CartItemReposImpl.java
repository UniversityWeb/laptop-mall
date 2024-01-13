package com.webteam.laptopmall.cartitem.repos;

import com.webteam.laptopmall.cartitem.CartItem;
import com.webteam.laptopmall.cartitem.CartItemQuery;
import com.webteam.laptopmall.infrastructure.repository.BaseReposImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.List;

public class CartItemReposImpl extends BaseReposImpl<CartItem, Long> implements CartItemRepos {

    private final Logger log = LogManager.getLogger(CartItemReposImpl.class);

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
    public boolean updateQtyOnly(Long cartItemId, int newQty) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int updatedEntities = 0;
        try {
            trans.begin();
            Query query = ciQuery.buildUpdateQtyOnly(em, cartItemId, newQty);
            updatedEntities = query.executeUpdate();
            trans.commit();
        } catch (NoResultException e) {
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return updatedEntities > 0;
    }

    @Override
    public List<CartItem> getListByUserId(Long userId) {
        return getResultList(em -> ciQuery.buildGetListByUserId(em, userId));
    }

    @Override
    public CartItem getByUserAndProductId(Long userId, Long productId) {
        return getSingleResult(em -> ciQuery.buildGetByUserAndProductId(em, userId, productId));
    }
}
