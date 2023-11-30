package com.webteam.laptopmall.service.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CartServiceImpl implements CartService {
    private CartItemRepos cartItemRepos;
    private CartItemMapper cartItemMapper;

    private NumberFormat currency;

    public CartServiceImpl(){
        currency= NumberFormat.getCurrencyInstance(Locale.US);
    }

    @Override
    public void save(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemMapper.toEntity(cartItemDTO);
        cartItemRepos.save(cartItem);
    }

    @Override
    public void addItem(List<CartItemDTO> cart, CartItemDTO cartItemDTO) {
        Long productId = cartItemDTO.getProduct().getId();
        Integer quantity = cartItemDTO.getQty();
        for (CartItemDTO item: cart) {
            if(item.getProduct().getId().equals(productId)){
                item.setQty(item.getQty() + quantity);
                cartItemRepos.updateQtyOnly(item.getCustomer().getId(), item.getQty());
                return;
            }
        }
        this.save(cartItemDTO);
        cart.add(cartItemDTO);
    }

    @Override
    public void deleteItemByProductId(List<CartItemDTO> cart, Long productId) {
        CartItemDTO cartItemDTO = getItemById(cart, productId);
        if (cartItemDTO != null){
            cartItemRepos.deleteById(cartItemDTO.getId());
            cart.remove(cartItemDTO);
        }
    }

    @Override
    public void updateItem(List<CartItemDTO> cart, CartItemDTO cartItem) {
        for (CartItemDTO item: cart) {
            if(item.getProduct().getModel().equals(cartItem.getProduct().getModel())){
                item.setQty(cartItem.getQty());
                cartItemRepos.updateQtyOnly(item.getCustomer().getId(), item.getQty());
                return;
            }
        }
    }

    @Override
    public CartItemDTO getItemById(List<CartItemDTO> cart, Long productId) {
        for (CartItemDTO item: cart) {
            if(item.getProduct().getId().equals(productId)){
                return item;
            }
        }
        return null;
    }

    @Override
    public void setCustomer(List<CartItemDTO> cart, UserDTO customer) {
        for (CartItemDTO item: cart) {
            item.setCustomer(customer);
        }
    }

    @Override
    public BigDecimal totalDiscountedAmountOfCart(List<CartItemDTO> cart) {
        BigDecimal totalDiscountedAmount = new BigDecimal(0);
        for (CartItemDTO item: cart) {
            totalDiscountedAmount.add(item.totalDiscountedAmountOfCartItem());
        }
        return totalDiscountedAmount;
    }

    @Override
    public BigDecimal totalOriginalAmountOfCart(List<CartItemDTO> cart) {
        BigDecimal totalOriginalAmount = new BigDecimal(0);
        for (CartItemDTO item: cart) {
            totalOriginalAmount.add(item.totalOriginalAmountOfCartItem());
        }
        return totalOriginalAmount;
    }

    @Override
    public BigDecimal totalDiscountAmountOfCart(List<CartItemDTO> cart) {
        BigDecimal totalDiscountAmount = new BigDecimal(0);
        for (CartItemDTO item: cart) {
            totalDiscountAmount.add(item.totalDiscountAmountOfCartItem());
        }
        return totalDiscountAmount;
    }

    @Override
    public String totalDiscountedAmountOfCartCurrentFormat(List<CartItemDTO> cart) {
        return currency.format(this.totalDiscountedAmountOfCart(cart));
    }

    @Override
    public String totalOriginalAmountOfCartCurrentFormat(List<CartItemDTO> cart) {
        return currency.format(this.totalOriginalAmountOfCart(cart));
    }

    @Override
    public String totalDiscountAmountOfCartCurrentFormat(List<CartItemDTO> cart) {
        return currency.format(this.totalDiscountAmountOfCart(cart));
    }
}
