package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void save(OrderDTO orderDTO);
    void setOrderItemByCart(OrderDTO order, List<CartItemDTO> cart);
}
