package com.webteam.laptopmall.query;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.entity.prod.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProdQuery {
    public TypedQuery<Product> buildGetProdsByModel(EntityManager em, String model) {
        String sqlStr = "SELECT p FROM Product p WHERE p.model LIKE :model";
        TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
        typedQuery.setParameter("model", model);
        return typedQuery;
    }

    public TypedQuery<Product> buildGetProdsByCategoryl(EntityManager em, ECategory eCategory) {
        String sqlStr = "SELECT p FROM Product p WHERE p.category = :eCategory";
        TypedQuery<Product> typedQuery = em.createQuery(sqlStr, Product.class);
        typedQuery.setParameter("eCategory", eCategory);
        return typedQuery;
    }
}
