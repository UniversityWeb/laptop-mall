package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartItemMapperTest {
    @Test
    void testToDTO() {
        CartItem cartItem = new CartItem(1L, 2, new User(), new Laptop());
        CartItemDTO cartItemDTO = CartItemMapper.INSTANCE.toDTO(cartItem);

        assertEquals(cartItem.getId(), cartItemDTO.getId());
        assertEquals(cartItem.getQty(), cartItemDTO.getQty());
        assertEquals(cartItem.getCustomer().getId(), cartItemDTO.getCustomer().getId());
        assertEquals(cartItem.getProduct().getId(), cartItemDTO.getProduct().getId());
    }

    @Test
    void testToEntity() {
        CartItemDTO cartItemDTO = new CartItemDTO(1L, 2, new UserDTO(), new LaptopDTO());
        CartItem cartItem = CartItemMapper.INSTANCE.toEntity(cartItemDTO);

        assertEquals(cartItemDTO.getId(), cartItem.getId());
        assertEquals(cartItemDTO.getQty(), cartItem.getQty());
        assertEquals(cartItemDTO.getCustomer().getId(), cartItem.getCustomer().getId());
        assertEquals(cartItemDTO.getProduct().getId(), cartItem.getProduct().getId());
    }
}