package com.webteam.laptopmall.service.cartItem;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;

public class CartItemServiceImpl implements CartItemService{

    private CartItemRepos cartItemRepos;
    private CartItemMapper cartItemMapper;

    @Override
    public void save(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemMapper.toEntity(cartItemDTO);
        cartItemRepos.save(cartItem);
    }

    @Override
    public void deleteById(Long id) {
        cartItemRepos.deleteById(id);
    }

    @Override
    public void updateQtyOnly(Long userId, Integer qty) {
        cartItemRepos.updateQtyOnly(userId, qty);
    }
}
