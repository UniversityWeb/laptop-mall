package com.webteam.laptopmall.product;

import com.webteam.laptopmall.product.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProdQuery {
    public TypedQuery<Product> buildGetProdsByModel(EntityManager em, String model) {
        String sqlStr = "SELECT p FROM Product p WHERE p.model LIKE :model and p.markAsDeleted = false";
        TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
        typedQuery.setParameter("model", model);
        return typedQuery;
    }

    public TypedQuery<Product> buildGetProdsByCategoryl(EntityManager em, ECategory eCategory) {
        String sqlStr = "SELECT p FROM Product p WHERE p.category = :eCategory and p.markAsDeleted = false ";
        TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
        typedQuery.setParameter("eCategory", eCategory);
        return typedQuery;
    }

    public TypedQuery<Product> buildGetProdsIsAvailable(EntityManager em) {
        String sqlStr = "SELECT p FROM Product p WHERE p.markAsDeleted = false";
        TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
        return typedQuery;
    }

}
