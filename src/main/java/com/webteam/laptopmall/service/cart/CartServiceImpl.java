package com.webteam.laptopmall.service.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.service.cartItem.CartItemService;
import com.webteam.laptopmall.service.cartItem.CartItemServiceImpl;
import com.webteam.laptopmall.utility.CurrencyUtil;

import java.math.BigDecimal;
import java.util.List;

public class CartServiceImpl implements CartService {

    private CartItemService cartItemService;
    public CartServiceImpl(){
        cartItemService = new CartItemServiceImpl();
    }

    @Override
    public void addItem(List<CartItemDTO> cart, CartItemDTO cartItemDTO) {
        Long productId = cartItemDTO.getProduct().getId();
        Integer quantity = cartItemDTO.getQty();
        for (CartItemDTO item: cart) {
            if(item.getProduct().getId().equals(productId)){
                item.setQty(item.getQty() + quantity);
                cartItemService.updateQtyOnly(item.getCustomer().getId(), item.getQty());
                return;
            }
        }
        cart.add(cartItemDTO);
        cartItemService.save(cartItemDTO);
    }

    @Override
    public void deleteItemByProductId(List<CartItemDTO> cart, Long productId) {
        CartItemDTO cartItemDTO = getItemOfCartById(cart, productId);
        if (cartItemDTO != null){
            cartItemService.deleteById(cartItemDTO.getId());
            cart.remove(cartItemDTO);
        }
    }

    @Override
    public void updateItem(List<CartItemDTO> cart,CartItemDTO cartItem) {
        for (CartItemDTO item: cart) {
            if(item.getProduct().getModel().equals(cartItem.getProduct().getModel())){
                item.setQty(cartItem.getQty());
                cartItemService.updateQtyOnly(item.getCustomer().getId(), item.getQty());
                return;
            }
        }
    }

    @Override
    public CartItemDTO getItemOfCartById(List<CartItemDTO> cart,Long productId) {
        for (CartItemDTO item: cart) {
            if(item.getProduct().getId().equals(productId)){
                return item;
            }
        }
        return null;
    }

    @Override
    public void setCustomer(List<CartItemDTO> cart,UserDTO customer) {
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
        return CurrencyUtil.getVNFormat(this.totalDiscountedAmountOfCart(cart));
    }

    @Override
    public String totalOriginalAmountOfCartCurrentFormat(List<CartItemDTO> cart) {
        return CurrencyUtil.getVNFormat(this.totalOriginalAmountOfCart(cart));
    }

    @Override
    public String totalDiscountAmountOfCartCurrentFormat(List<CartItemDTO> cart) {
        return CurrencyUtil.getVNFormat(this.totalDiscountAmountOfCart(cart));
    }

    @Override
    public int totalQtyOfCart(List<CartItemDTO> cart) {
        int qty = 0;
        for (CartItemDTO cartItemDTO: cart) {
            qty += cartItemDTO.getQty();
        }
        return qty;
    }
}
