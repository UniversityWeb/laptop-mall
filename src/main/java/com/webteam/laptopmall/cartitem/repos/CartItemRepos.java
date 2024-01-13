package com.webteam.laptopmall.cartitem.repos;

import com.webteam.laptopmall.cartitem.CartItem;
import com.webteam.laptopmall.infrastructure.repository.BaseRepos;

import java.util.List;

public interface CartItemRepos extends BaseRepos<CartItem, Long> {
    boolean updateQtyOnly(Long cartItemId, int newQty);
    List<CartItem> getListByUserId(Long userId);
    CartItem getByUserAndProductId(Long userId, Long productId);
}
