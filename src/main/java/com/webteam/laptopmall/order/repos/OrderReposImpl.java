package com.webteam.laptopmall.order.repos;

import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.product.entity.Product;
import com.webteam.laptopmall.order.OrderQuery;
import com.webteam.laptopmall.infrastructure.repository.BaseReposImpl;
import com.webteam.laptopmall.product.repos.ProdReposImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

public class OrderReposImpl extends BaseReposImpl<Order, Long> implements OrderRepos {

    private static final Logger log = LogManager.getLogger(OrderReposImpl.class);

    private OrderQuery odQuery;

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
            log.error(e.getMessage());
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
