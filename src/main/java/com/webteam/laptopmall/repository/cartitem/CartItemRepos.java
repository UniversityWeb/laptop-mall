package com.webteam.laptopmall.repository.cartitem;

import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.List;

public interface CartItemRepos extends BaseRepos<CartItem, Long> {
    boolean updateQtyOnly(Long userId, int newQty);
    List<CartItem> getByUserId(Long userId);
}
