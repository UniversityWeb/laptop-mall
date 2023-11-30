package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.entity.OrderItem;
import com.webteam.laptopmall.mapper.CartItemMapper;
import com.webteam.laptopmall.mapper.OrderItemMapper;
import com.webteam.laptopmall.mapper.OrderMapper;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.repository.order.OrderRepos;
import com.webteam.laptopmall.repository.orderItem.OrderItemRepos;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService{
    private OrderRepos orderRepos;
    private OrderMapper orderMapper;

    private CartItemRepos cartItemRepos;

    @Override
    public void save(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        orderRepos.save(order);
    }

    @Override
    public void setOrderItemByCart(OrderDTO orderDTO, List<CartItemDTO> cart) {
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (CartItemDTO item: cart) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setQty(item.getQty());
            orderItemDTO.setProduct(item.getProduct());
            orderItemDTO.setCurPrice(item.totalDiscountedAmountOfCartItem());
            orderItems.add(orderItemDTO);
            cartItemRepos.deleteById(item.getId());
        }
        orderDTO.setOrderItems(orderItems);
        this.save(orderDTO);
    }
}
