package com.webteam.laptopmall.service.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.service.cartItem.CartItemService;
import com.webteam.laptopmall.utility.CurrencyUtil;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartServiceImpl implements CartService {

    private List<CartItemDTO> cart;
    private CartItemService cartItemService;

    public CartServiceImpl(List<CartItemDTO> cart){
        this.cart = cart;
    }

    @Override
    public void addItem(CartItemDTO cartItemDTO) {
        Long productId = cartItemDTO.getProduct().getId();
        Integer quantity = cartItemDTO.getQty();
        for (CartItemDTO item: this.cart) {
            if(item.getProduct().getId().equals(productId)){
                item.setQty(item.getQty() + quantity);
                cartItemService.updateQtyOnly(item.getCustomer().getId(), item.getQty());
                return;
            }
        }
        this.cart.add(cartItemDTO);
        cartItemService.save(cartItemDTO);
    }

    @Override
    public void deleteItemByProductId(Long productId) {
        CartItemDTO cartItemDTO = getItemOfCartById(productId);
        if (cartItemDTO != null){
            cartItemService.deleteById(cartItemDTO.getId());
            this.cart.remove(cartItemDTO);
        }
    }

    @Override
    public void updateItem(CartItemDTO cartItem) {
        for (CartItemDTO item: this.cart) {
            if(item.getProduct().getModel().equals(cartItem.getProduct().getModel())){
                item.setQty(cartItem.getQty());
                cartItemService.updateQtyOnly(item.getCustomer().getId(), item.getQty());
                return;
            }
        }
    }

    @Override
    public CartItemDTO getItemOfCartById(Long productId) {
        for (CartItemDTO item: this.cart) {
            if(item.getProduct().getId().equals(productId)){
                return item;
            }
        }
        return null;
    }

    @Override
    public void setCustomer(UserDTO customer) {
        for (CartItemDTO item: this.cart) {
            item.setCustomer(customer);
        }
    }

    @Override
    public BigDecimal totalDiscountedAmountOfCart() {
        BigDecimal totalDiscountedAmount = new BigDecimal(0);
        for (CartItemDTO item: this.cart) {
            totalDiscountedAmount.add(item.totalDiscountedAmountOfCartItem());
        }
        return totalDiscountedAmount;
    }

    @Override
    public BigDecimal totalOriginalAmountOfCart() {
        BigDecimal totalOriginalAmount = new BigDecimal(0);
        for (CartItemDTO item: this.cart) {
            totalOriginalAmount.add(item.totalOriginalAmountOfCartItem());
        }
        return totalOriginalAmount;
    }

    @Override
    public BigDecimal totalDiscountAmountOfCart() {
        BigDecimal totalDiscountAmount = new BigDecimal(0);
        for (CartItemDTO item: this.cart) {
            totalDiscountAmount.add(item.totalDiscountAmountOfCartItem());
        }
        return totalDiscountAmount;
    }

    @Override
    public String totalDiscountedAmountOfCartCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.totalDiscountedAmountOfCart());
    }

    @Override
    public String totalOriginalAmountOfCartCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.totalOriginalAmountOfCart());
    }

    @Override
    public String totalDiscountAmountOfCartCurrentFormat() {
        return CurrencyUtil.getVNFormat(this.totalDiscountAmountOfCart());
    }

    @Override
    public int totalQtyOfCart() {
        int qty = 0;
        for (CartItemDTO cartItemDTO: this.cart) {
            qty += cartItemDTO.getQty();
        }
        return qty;
    }
}
