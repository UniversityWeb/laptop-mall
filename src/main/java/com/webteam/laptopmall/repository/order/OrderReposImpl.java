package com.webteam.laptopmall.repository.order;

import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.query.OrderQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderReposImpl extends BaseReposImpl<Order, Long> implements OrderRepos {

    private OrderQuery odQuery;
    private static final Logger log = Logger.getLogger(ProdReposImpl.class.getName());

    public OrderReposImpl() {
        super();
        odQuery = new OrderQuery();
    }

    @Override
    protected Class<Order> getClassType() {
        return Order.class;
    }

    @Override
    public Order update(Order order) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(order);
            trans.commit();
            return order;
        } catch (NoResultException e) {
            log.log(Level.SEVERE, e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<Order> getListByUserIdAndStatus(Long userId, Order.EStatus status) {
        return getResultList(em -> odQuery.buildGetListByUserIdAndStatus(em, userId, status));
    }

    @Override
    public List<Order> getListByUserId(Long userId) {
        return getResultList(em -> odQuery.buildListGetByUserId(em, userId));
    }

    @Override
    public Order getByUserAndOrderId(Long userId, Long orderId) {
        return getSingleResult(em -> odQuery.getByUserAndOrderId(em, userId, orderId));
    }
}
