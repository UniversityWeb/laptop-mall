package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.entity.Order;

import java.util.List;

public interface OrderService {
    OrderDTO save(OrderDTO orderDTO);
    void update(OrderDTO orderDTO);
    void setOrderItemByCart(OrderDTO orderDTO, List<CartItemDTO> cart);
    String getMailBody (OrderDTO orderDTO);
    OrderDTO saveOrderAndDeleteCart(OrderDTO order, List<CartItemDTO> cart);
    List<OrderDTO> getListByUserIdAndStatus(Long userId, Order.EStatus status);
    List<OrderDTO> getALl();
    OrderDTO getByUserAndOrderId(Long userId, Long orderId);
    List<OrderDTO> getListByUserId(Long userId);
}
