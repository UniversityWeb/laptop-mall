package com.webteam.laptopmall.service.cartItem;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.repository.cartitem.CartItemReposImpl;

import java.util.List;

public class CartItemServiceImpl implements CartItemService{

    private CartItemRepos cartItemRepos;

    public CartItemServiceImpl(){
        cartItemRepos = new CartItemReposImpl();
    }

    @Override
    public void save(CartItemDTO cartItemDTO) {
        CartItem cartItem = CartItemMapper.INSTANCE.toEntity(cartItemDTO);
        cartItemRepos.save(cartItem);
    }

    @Override
    public void deleteById(Long id) {
        cartItemRepos.deleteById(id);
    }

    @Override
    public void updateQtyOnly(Long cartItemId, Integer qty) {
        cartItemRepos.updateQtyOnly(cartItemId, qty);
    }

    @Override
    public OrderItemDTO toOrderItem(CartItemDTO cartItemDTO) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setQty(cartItemDTO.getQty());
        orderItemDTO.setCurPrice(cartItemDTO.totalDiscountedAmountOfCartItem());
        orderItemDTO.setProduct(cartItemDTO.getProduct());
        return orderItemDTO;
    }

    @Override
    public List<CartItem> getByUserId(Long userId) {
        return cartItemRepos.getByUserId(userId);
    }
}
