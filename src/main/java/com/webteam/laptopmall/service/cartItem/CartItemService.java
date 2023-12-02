package com.webteam.laptopmall.service.cartItem;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.CartItem;

import java.util.List;

public interface CartItemService {

    void save(CartItemDTO cartItemDTO);

    void deleteById(Long id);
    void updateQtyOnly(Long cartItemId, Integer qty);
    OrderItemDTO toOrderItem(CartItemDTO item);

    List<CartItem> getByUserId(Long userId);
}
