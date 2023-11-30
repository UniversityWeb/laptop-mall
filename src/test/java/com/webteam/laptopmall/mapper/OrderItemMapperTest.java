package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.entity.OrderItem;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.entity.user.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemMapperTest {
    @Test
    void testToDTO() {
        OrderItem orderItem = new OrderItem(1L, new Laptop(), 1, new BigDecimal(0));
        OrderItemDTO orderItemDTO = OrderItemMapper.INSTANCE.toDTO(orderItem);

        assertEquals(orderItem.getId(), orderItemDTO.getId());
        assertEquals(orderItem.getProduct().getId(), orderItemDTO.getProduct().getId());
        assertEquals(orderItem.getQty(), orderItemDTO.getQty());
        assertEquals(orderItem.getCurPrice(), orderItemDTO.getCurPrice());
    }

    @Test
    void testToEntity() {
        OrderItemDTO orderItemDTO = new OrderItemDTO(1L, new LaptopDTO(), 1, new BigDecimal(0));
        OrderItem orderItem = OrderItemMapper.INSTANCE.toEntity(orderItemDTO);

        assertEquals(orderItemDTO.getId(), orderItem.getId());
        assertEquals(orderItemDTO.getProduct().getId(), orderItem.getProduct().getId());
        assertEquals(orderItemDTO.getQty(), orderItem.getQty());
        assertEquals(orderItemDTO.getCurPrice(), orderItem.getCurPrice());
    }
}
