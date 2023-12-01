package com.webteam.laptopmall.service.cartItem;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.mapper.CartItemMapperImpl;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.repository.cartitem.CartItemReposImpl;

public class CartItemServiceImpl implements CartItemService{

    private CartItemRepos cartItemRepos;
    private CartItemMapper cartItemMapper;

    public CartItemServiceImpl(){
        cartItemRepos = new CartItemReposImpl();
        cartItemMapper = new CartItemMapperImpl();
    }

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
