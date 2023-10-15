package com.webteam.laptopmall.repository.category;

import com.webteam.laptopmall.entity.Category;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

public class CategoryReposImpl extends BaseReposImpl<Category, Integer> implements CategoryRepos {
    @Override
    protected Class<Category> getClassType() {
        return Category.class;
    }
}
