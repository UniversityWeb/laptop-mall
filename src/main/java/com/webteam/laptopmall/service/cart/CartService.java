package com.webteam.laptopmall.service.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.user.User;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    void save(CartItemDTO cartItemDTO);
    void addItem(List<CartItemDTO> cart, CartItemDTO cartItem);
    void deleteItemByProductId(List<CartItemDTO> cart, Long productId);
    void updateItem(List<CartItemDTO> cart, CartItemDTO cartItem);
    CartItemDTO getItemById(List<CartItemDTO> cart, Long productId);
    void setCustomer(List<CartItemDTO> cart, UserDTO customer);

    BigDecimal totalDiscountedAmountOfCart(List<CartItemDTO> cart);
    BigDecimal totalOriginalAmountOfCart(List<CartItemDTO> cart);
    BigDecimal totalDiscountAmountOfCart(List<CartItemDTO> cart);

    String totalDiscountedAmountOfCartCurrentFormat(List<CartItemDTO> cart);
    String totalOriginalAmountOfCartCurrentFormat(List<CartItemDTO> cart);
    String totalDiscountAmountOfCartCurrentFormat(List<CartItemDTO> cart);
}
