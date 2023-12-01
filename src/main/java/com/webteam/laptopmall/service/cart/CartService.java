package com.webteam.laptopmall.service.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    void addItem( CartItemDTO cartItem);
    void deleteItemByProductId(Long productId);
    void updateItem(CartItemDTO cartItem);
    CartItemDTO getItemOfCartById(Long productId);
    void setCustomer(UserDTO customer);

    BigDecimal totalDiscountedAmountOfCart();
    BigDecimal totalOriginalAmountOfCart();
    BigDecimal totalDiscountAmountOfCart();

    String totalDiscountedAmountOfCartCurrentFormat();
    String totalOriginalAmountOfCartCurrentFormat();
    String totalDiscountAmountOfCartCurrentFormat();
    int totalQtyOfCart();
}
