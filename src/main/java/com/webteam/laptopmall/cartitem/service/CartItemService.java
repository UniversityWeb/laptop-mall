package com.webteam.laptopmall.cartitem.service;

import com.webteam.laptopmall.cartitem.CartItemDTO;
import com.webteam.laptopmall.orderitem.OrderItemDTO;

import java.util.List;

public interface CartItemService {

    void save(CartItemDTO cartItemDTO);

    void deleteById(Long id);
    void updateQtyOnly(Long cartItemId, Integer qty);
    OrderItemDTO toOrderItem(CartItemDTO item);

    List<CartItemDTO> getListByUserId(Long userId);
    CartItemDTO getByUserAndProductId(Long userId, Long productId);
}
