package com.webteam.laptopmall.service.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.service.cartItem.CartItemService;
import com.webteam.laptopmall.service.cartItem.CartItemServiceImpl;
import com.webteam.laptopmall.utility.CurrencyUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CartServiceImpl implements CartService {

    private CartItemService cartItemService;
    private static final Logger logger = Logger.getLogger(CartServiceImpl.class.getName());
    public CartServiceImpl(){
        cartItemService = new CartItemServiceImpl();
    }

    @Override
    public void addItem(CartItemDTO cartItemDTO) {
        Long productId = cartItemDTO.getProduct().getId();
        Long customerId = cartItemDTO.getCustomer().getId();
        Integer quantity = cartItemDTO.getQty();
        CartItemDTO theCartItem = cartItemService.getByUserAndProductId(customerId, productId);
        if(theCartItem != null){
            quantity += theCartItem.getQty();
            if (quantity > theCartItem.getProduct().getStockQty()){
                quantity = theCartItem.getProduct().getStockQty();
            }
            cartItemService.updateQtyOnly(theCartItem.getId(), quantity);
            return;
        }
        cartItemService.save(cartItemDTO);
    }

    @Override
    public void deleteItem(CartItemDTO cartItemDTO) {
        Long userId = cartItemDTO.getCustomer().getId();
        Long productId = cartItemDTO.getProduct().getId();
        CartItemDTO theCartItemDTO = cartItemService.getByUserAndProductId(userId, productId);
        cartItemService.deleteById(theCartItemDTO.getId());
    }

    @Override
    public void updateQtyOnly(CartItemDTO cartItemDTO) {
        Long cartItemId = cartItemDTO.getId();
        Integer quantity = cartItemDTO.getQty();
        if (quantity > cartItemDTO.getProduct().getStockQty()){
            quantity = cartItemDTO.getProduct().getStockQty();
        }
        cartItemService.updateQtyOnly(cartItemId, quantity);
    }

    @Override
    public CartItemDTO getItemOfCartById(List<CartItemDTO> cart, Long productId) {
        return cart.stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);
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
            totalDiscountedAmount = totalDiscountedAmount.add(item.totalDiscountedAmountOfCartItem());
        }
        return totalDiscountedAmount;
    }

    @Override
    public BigDecimal totalOriginalAmountOfCart(List<CartItemDTO> cart) {
        BigDecimal totalOriginalAmount = new BigDecimal(0);
        for (CartItemDTO item: cart) {
            totalOriginalAmount = totalOriginalAmount.add(item.totalOriginalAmountOfCartItem());
        }
        return totalOriginalAmount;
    }

    @Override
    public BigDecimal totalDiscountAmountOfCart(List<CartItemDTO> cart) {
        BigDecimal totalDiscountAmount = new BigDecimal(0);
        for (CartItemDTO item: cart) {
            totalDiscountAmount = totalDiscountAmount.add(item.totalDiscountAmountOfCartItem());
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

    @Override
    public List<CartItemDTO> getCartByUserId(Long userId) {
        return cartItemService.getListByUserId(userId);
    }
}
