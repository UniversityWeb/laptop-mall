package com.webteam.laptopmall.repository.prod;

import com.webteam.laptopmall.entity.Product;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductReposImpl extends BaseReposImpl<Product, Long> implements ProductRepos {

    private final Logger log = Logger.getLogger(ProductReposImpl.class.getName());

    public ProductReposImpl() {
        super();
    }

    @Override
    protected Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public Product update(Product prod) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(prod);
            trans.commit();
            return prod;
        } catch (NoResultException e) {
            log.log(Level.SEVERE, e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return null;
    }
}
