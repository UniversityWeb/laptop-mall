package com.webteam.laptopmall.repository.cartitem;

import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.List;

public interface CartItemRepos extends BaseRepos<CartItem, Long> {
    boolean updateQtyOnly(Long cartItemId, int newQty);
    List<CartItem> getListByUserId(Long userId);
    CartItem getByUserAndProductId(Long userId, Long productId);
}
