package com.webteam.laptopmall.product.repos;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.entity.Product;
import com.webteam.laptopmall.infrastructure.repository.BaseRepos;

import java.util.List;

public interface ProdRepos extends BaseRepos<Product, Long> {
    Product update(Product prod);
    List<Product> getProdsByModel(String model);
    List<Product> getProdsByCategory(ECategory eCategory);
    int markProductAsDeleted(Long prodId);
    List<Product> getProdsIsAvailable();
}

