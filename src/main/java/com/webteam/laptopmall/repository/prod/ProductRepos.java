package com.webteam.laptopmall.repository.prod;

import com.webteam.laptopmall.entity.Product;
import com.webteam.laptopmall.repository.base.BaseRepos;

public interface ProductRepos extends BaseRepos<Product, Long> {
    Product update(Product prod);
}

