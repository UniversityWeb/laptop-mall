package com.webteam.laptopmall.service.cartItem;

import com.webteam.laptopmall.dto.CartItemDTO;

public interface CartItemService {

    void save(CartItemDTO cartItemDTO);

    void deleteById(Long id);
    void updateQtyOnly(Long cartItemId, Integer qty);
}
