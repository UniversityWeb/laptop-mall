package com.webteam.laptopmall.repository.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.query.ProdQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdReposImpl extends BaseReposImpl<Product, Long> implements ProdRepos {

    private static final Logger log = Logger.getLogger(ProdReposImpl.class.getName());

    private ProdQuery pQuery;

    public ProdReposImpl() {
        super();
        pQuery = new ProdQuery();
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

    @Override
    public int deleteAll() {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        int deletedEntities = 0;
//
//        try {
//            trans.begin();
//            List<Product> products = getAll();
//
//            for (Product product : products) {
//                deleteById(product.getId());
//                deletedEntities++;
//            }
//
//            trans.commit();
//        } catch (Exception e) {
//            log.log(Level.SEVERE, e.getMessage());
//            trans.rollback();
//        } finally {
//            em.close();
//        }
//
//        return deletedEntities;

        int deletedEntities = 0;

        List<Product> products = getAll();
        for (Product product : products) {
            deleteById(product.getId());
            deletedEntities++;
        }
        return deletedEntities;
    }

    @Override
    public List<Product> getProdsByModel(String model) {
        return getResultList(em -> pQuery.buildGetProdsByModel(em, model));
    }

    @Override
    public List<Product> getProdsByCategory(ECategory eCategory) {
        return getResultList(em -> pQuery.buildGetProdsByCategoryl(em, eCategory));
    }
}
