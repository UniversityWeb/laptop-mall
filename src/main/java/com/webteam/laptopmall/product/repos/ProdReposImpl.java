package com.webteam.laptopmall.product.repos;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.entity.Product;
import com.webteam.laptopmall.product.ProdQuery;
import com.webteam.laptopmall.infrastructure.repository.BaseReposImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ProdReposImpl extends BaseReposImpl<Product, Long> implements ProdRepos {

    private static final Logger log = LogManager.getLogger(ProdReposImpl.class);

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
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public int deleteAll() {

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

    @Override
    public int markProductAsDeleted(Long prodId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        int deletedRow = 0;

        try {
            trans.begin();
            String sqlStr = String.format("UPDATE Product p SET p.markAsDeleted = true WHERE p.id = %s", prodId.toString());
            Query query = em.createQuery(sqlStr);
            deletedRow = query.executeUpdate();
            trans.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }

        return deletedRow;
    }

    @Override
    public List<Product> getProdsIsAvailable() {
        return getResultList(em -> pQuery.buildGetProdsIsAvailable(em));
    }
}
