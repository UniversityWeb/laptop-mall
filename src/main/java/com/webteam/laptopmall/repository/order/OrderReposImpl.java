package com.webteam.laptopmall.repository.order;

import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.query.OrderQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
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
        return getResultList(em -> odQuery.buildGetListGetByUserId(em, userId));
    }

    @Override
    public Order getByUserAndOrderId(Long userId, Long orderId) {
        return getSingleResult(em -> odQuery.buildGetByUserAndOrderId(em, userId, orderId));
    }

    @Override
    public List<Order> getListByStatusAndTime(Order.EStatus status, Integer month, Integer year) {
        return getResultList(em -> odQuery.buildGetListByStatusAndTime(em, status, month, year));
    }

    @Override
    public List<Order> getListByTime(Integer month, Integer year) {
        return getResultList(em -> odQuery.buildGetListByTime(em, month, year));
    }

    @Override
    public void getDataProductDESCByTime(List<Product> products, List<Integer> qtys, Integer month, Integer year) {
        List<Object[]> results = getResultList(em -> odQuery.buildGetDataProductDESCByTime(em, month, year));
        for (Object[] row: results) {
            products.add((Product) row[0]);
            qtys.add(Integer.valueOf(row[1].toString()));
        }
    }

    @Override
    public void getDataProductASCByTime(List<Product> products, List<Integer> qtys, Integer month, Integer year) {
        List<Object[]> results = getResultList(em -> odQuery.buildGetDataProductASCByTime(em, month, year));
        for (Object[] row: results) {
            products.add((Product) row[0]);
            qtys.add(Integer.valueOf(row[1].toString()));
        }
    }

    @Override
    public List<Order> getOrdersContainProdID(Long prodID) {
        return getResultList(em -> odQuery.buildGetOrdersContainProdID(em, prodID));
    }
}
