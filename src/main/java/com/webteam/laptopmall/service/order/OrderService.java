package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO save(OrderDTO orderDTO);
    void setOrderItemByCart(OrderDTO orderDTO, List<CartItemDTO> cart);
    String getMailBody (OrderDTO orderDTO);
    OrderDTO saveOrderAndDeleteCart(OrderDTO order, List<CartItemDTO> cart);
}
