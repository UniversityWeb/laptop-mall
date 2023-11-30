package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.entity.Payment;
import com.webteam.laptopmall.entity.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderMapperTest {
    @Test
    void testToDTO() {
        Order order = new Order(1L, new User(), new Date(), "At Home", Order.EStatus.PENDING, new Payment(), "Note", new ArrayList<>());
        OrderDTO orderDTO = OrderMapper.INSTANCE.toDTO(order);

        assertEquals(order.getId(), orderDTO.getId());
        assertEquals(order.getCustomer().getId(), orderDTO.getCustomer().getId());
        assertEquals(order.getOrderDate().getTime(), orderDTO.getOrderDate().getTime());
        assertEquals(order.getDeliveryMethod(), orderDTO.getDeliveryMethod());
        assertEquals(order.getStatus(), orderDTO.getStatus());
        assertEquals(order.getPayment().getId(), orderDTO.getPayment().getId());
        assertEquals(order.getNote(), orderDTO.getNote());
        assertEquals(order.getOrderItems().size(), orderDTO.getOrderItems().size());
    }

    @Test
    void testToEntity() {
        OrderDTO orderDTO = new OrderDTO(1L, new UserDTO(), new Date(), "At Home", Order.EStatus.PENDING, new Payment(), "Note", new ArrayList<>());
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);

        assertEquals(orderDTO.getId(), order.getId());
        assertEquals(orderDTO.getCustomer().getId(), order.getCustomer().getId());
        assertEquals(orderDTO.getOrderDate().getTime(), order.getOrderDate().getTime());
        assertEquals(orderDTO.getDeliveryMethod(), order.getDeliveryMethod());
        assertEquals(orderDTO.getStatus(), order.getStatus());
        assertEquals(orderDTO.getPayment().getId(), order.getPayment().getId());
        assertEquals(orderDTO.getNote(), order.getNote());
        assertEquals(orderDTO.getOrderItems().size(), order.getOrderItems().size());
    }
}
