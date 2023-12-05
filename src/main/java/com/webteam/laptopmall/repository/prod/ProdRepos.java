package com.webteam.laptopmall.repository.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.List;

public interface ProdRepos extends BaseRepos<Product, Long> {
    Product update(Product prod);
    List<Product> getProdsByModel(String model);
    List<Product> getProdsByCategory(ECategory eCategory);
}

