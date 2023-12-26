package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
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
    String[] convertListStatusToString(Order.EStatus[] statuses);
    List<Integer> getValueByStatusAndTime(Order.EStatus[] statuses, Integer month, Integer year);
    String getTotalRevenueByTime(Integer month, Integer year);
    List<OrderDTO> getListByTime(Integer month, Integer year);
    Integer getNoOrderByTime(Integer month, Integer year);
    void setDataBestSellProductByTime(String[] topBestSellProductsName, List<Integer> topBestSellProductsQty, Integer month, Integer year);
    void setDataLeastSellProductByTime(String[] topLeastSellProductsName, List<Integer> topLeastSellProductsQty, Integer month, Integer year);

    List<OrderDTO> getOrdersContainProdID(Long prodId);
}
