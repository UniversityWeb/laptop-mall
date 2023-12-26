package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.mapper.OrderMapper;
import com.webteam.laptopmall.mapper.ProductMapper;
import com.webteam.laptopmall.repository.order.OrderRepos;
import com.webteam.laptopmall.repository.order.OrderReposImpl;
import com.webteam.laptopmall.service.cartItem.CartItemService;
import com.webteam.laptopmall.service.cartItem.CartItemServiceImpl;
import com.webteam.laptopmall.service.orderItem.OrderItemService;
import com.webteam.laptopmall.service.orderItem.OrderItemServiceImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;
import com.webteam.laptopmall.utility.CurrencyUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService{
    private OrderRepos orderRepos;
    private CartItemService cartItemService;
    private ProdService prodService;

    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class.getName());

    public OrderServiceImpl(){
        orderRepos = new OrderReposImpl();
        cartItemService = new CartItemServiceImpl();
        prodService = new ProdServiceImpl();
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
        return OrderMapper.INSTANCE.toDTO(orderRepos.save(order));
    }

    @Override
    public void update(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
        orderRepos.update(order);
    }

    @Override
    public void setOrderItemByCart(OrderDTO orderDTO, List<CartItemDTO> cart) {
        List<OrderItemDTO> orderItems = new ArrayList<>();
        for (CartItemDTO item: cart) {
            OrderItemDTO orderItemDTO = cartItemService.toOrderItem(item);
            orderItems.add(orderItemDTO);
        }
        orderDTO.setOrderItems(orderItems);
    }

    @Override
    public String getMailBody(OrderDTO orderDTO) {
        UserDTO customer = orderDTO.getCustomer();

        String listItem = "";
        for (OrderItemDTO orderItemDTO: orderDTO.getOrderItems()) {
            listItem += "<tr>"+
                    "<td style='width: 150px; overflow: auto;'>" + orderItemDTO.getProduct().getModel() +"</td>" +
                    "<td style='width: 50px; overflow: auto;'>"+ orderItemDTO.getProduct().getColor() +"</td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'> x"+ orderItemDTO.getQty() +"</td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'><del>"+ orderItemDTO.getProduct().getPriceCurrentFormat() +"</del></td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'>"+ orderItemDTO.getProduct().getDiscountedPriceCurrentFormat() +"</td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'>" + orderItemDTO.totalDiscountedOfCartItemCurrentFormat() +"</td></tr>";
        }

        return  "<section style='width: 720px; height: auto;'>" +
                "<h3>Thank You for Your Recent Purchase at Laptop Mall</h3>" +
                "<p>Dear " + customer.getFullName() + ",</p>" +
                "<p>We hope this message finds you well. We sincerely appreciate " +
                "your recent purchase of laptop and accessories from our store. " +
                "Your decision to choose our products means a lot to us, " +
                "and we are grateful for the trust you have placed in our brand.</p>" +
                "<p>Enclosed with this email is the detailed invoice for your purchase. " +
                "Please take a moment to review the invoice, ensuring that all details are accurate. " +
                "If you have any questions or concerns regarding the invoice or " +
                "any aspect of your purchase, our customer support team is readily available to assist you.</p>" +

                "<div style='width: 700px; height: auto; padding: 20px; border: 1px solid #000; border-radius: 15px;'>" +
                "<div><h1 style='height: 15px;'>Your Invoice</h1></div>" +
                "<hr style='width: 100%; margin: 0; border-bottom: 1px solid #bbbbbb;'>" +
                "<div style='width: 100%;'>" +
                "<p><strong>Order ID: "+ orderDTO.getId() +"</strong></p>" +
                "<hr style='width: 100%; margin: 0; border-bottom: 1px solid #bbbbbb;'>" +
                "<div style='padding: 5px 10px;'>" +
                "<p>Order date: " + orderDTO.getOrderDate().toString() + "</p>" +
                "<p>Full Name: " + customer.getFullName() + "</p>" +
                "<p>Phone Number: " + customer.getPhoneNo() + "</p>" +
                "<p>Payment Method: " + orderDTO.getPayment().getPaymentMethod() + "</p>" +
                "<p>Delivery Method: " + orderDTO.getDeliveryMethod() + "</p> </div>" +
                "<hr style='width: 100%; margin: 0; border-bottom: 1px solid #bbbbbb;'>" +
                "<p>Order Details:</p>" +
                "<table style='display: flex; flex-direction: column; align-items: center;'>"
                + listItem + "<td>Total:</td><td style='width: 100px; overflow: auto; text-align: right'>&nbsp;</td>" +
                "<td style='width: 100px; overflow: auto; text-align: right'>&nbsp;</td>" +
                "<td style='width: 100px; overflow: auto; text-align: right'>&nbsp;</td>" +
                "<td style='width: 100px; overflow: auto; text-align: right'>&nbsp;</td>" +
                "<td style='width: 100px; overflow: auto; text-align: right;'>"
                + orderDTO.totalDiscountedAmountOfOrderCurrentFormat() + "</td></tr></table>" +
                "<hr style='width: 100%; margin: 0; border-bottom: 1px solid #bbbbbb;'>" +
                "<p style='width: 100%; text-align: center; font-size: 1.2em;'><i>Thank you!</i></p></div></div>" +
                "<p>At <strong>Laptop Mall</strong>, we are committed to providing top-quality laptops and accessories, " +
                "as well as an exceptional shopping experience. Your satisfaction is our priority, " +
                "and we are here to address any inquiries you may have.</p>" +
                "<p>We value your feedback and would love to hear about your experience with our products and services. " +
                "Your insights help us continually improve and better meet the needs of our customers.</p>" +
                "<p>Thank you once again for choosing <strong>Laptop Mall</strong>. We look forward to serving you " +
                "in the future and providing you with the best in technology and customer satisfaction.</p>" +
                "<p>Best regards,</p><p>Laptop Mall,</p><p>laptopmall@gmail.com,</p></section>";
    }

    @Override
    public OrderDTO saveOrderAndDeleteCart(OrderDTO order, List<CartItemDTO> cart) {
        cart.forEach(cartItem ->{
            cartItem.getProduct().setStockQty(cartItem.getProduct().getStockQty() - cartItem.getQty());
            prodService.update(cartItem.getProduct());
            cartItemService.deleteById(cartItem.getId());
        });
        return this.save(order);
    }

    @Transactional
    @Override
    public List<OrderDTO> getListByUserIdAndStatus(Long userId, Order.EStatus status) {
        try{
            List<Order> orders = orderRepos.getListByUserIdAndStatus(userId, status);
            return orders.stream()
                    .map(OrderMapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<OrderDTO> getALl() {
        try{
            List<Order> orders = orderRepos.getAll();
            return orders.stream()
                    .map(OrderMapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }

    @Override
    public OrderDTO getByUserAndOrderId(Long userId, Long orderId) {
        try{
            Order order = orderRepos.getByUserAndOrderId(userId, orderId);
            return OrderMapper.INSTANCE.toDTO(order);
        }catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<OrderDTO> getListByUserId(Long userId) {
        try{
            List<Order> orders = orderRepos.getListByUserId(userId);
            return orders.stream()
                    .map(OrderMapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }

    @Override
    public String [] convertListStatusToString(Order.EStatus[] values) {
        List<String> orderStatuses = new ArrayList<>();
        for (Order.EStatus status: values) {
            orderStatuses.add(String.valueOf(status));
        }
        return orderStatuses.toArray(new String[0]);
    }

    @Override
    public List<Integer> getValueByStatusAndTime(Order.EStatus[] statuses, Integer month, Integer year) {
        List<Integer> orderStatusValues = new ArrayList<>();
        for (Order.EStatus status : statuses) {
            List<Order> orders = orderRepos.getListByStatusAndTime(status, month, year);
            orderStatusValues.add(orders.size());
        }
        return orderStatusValues;
    }

    @Override
    public String getTotalRevenueByTime(Integer month, Integer year) {
        BigDecimal total = new BigDecimal(0);
        List<OrderDTO> orders = this.getListByTime(month, year);
        for (OrderDTO order: orders) {
            total = total.add(order.totalDiscountedAmountOfOrder());
        }
        return CurrencyUtil.getVNFormat(total);
    }

    @Override
    public List<OrderDTO> getListByTime(Integer month, Integer year) {
        List<Order> orders = orderRepos.getListByTime(month, year);
        System.out.println(orders.size());
        return orders.stream()
                .map(OrderMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNoOrderByTime(Integer month, Integer year) {
        List<Order> orders = orderRepos.getListByTime(month, year);
        System.out.println(orders.size());
        return orders.size();
    }

    @Override
    public void setDataBestSellProductByTime(
            String[] topBestSellProductsName, List<Integer> topBestSellProductsQty,
            Integer month, Integer year) {

        List<Product> products = new ArrayList<>();
        List<Integer> qtys = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        orderRepos.getDataProductDESCByTime(products, qtys, month, year);
        products.forEach(product -> productName.add(product.getModel()));
        qtys.forEach(qty -> topBestSellProductsQty.add(qty));
        System.out.println(productName);
        topBestSellProductsName = productName.toArray(topBestSellProductsName);

    }

    @Override
    public void setDataLeastSellProductByTime(
            String[] topLeastSellProductsName, List<Integer> topLeastSellProductsQty,
            Integer month, Integer year) {

        List<Product> products = new ArrayList<>();
        List<Integer> qtys = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        orderRepos.getDataProductASCByTime(products, qtys, month, year);
        products.forEach(product -> productName.add(product.getModel()));
        qtys.forEach(qty -> topLeastSellProductsQty.add(qty));
        topLeastSellProductsName = productName.toArray(topLeastSellProductsName);
    }

    @Override
    public List<OrderDTO> getOrdersContainProdID(Long prodId) {
        try{
            List<Order> orders = orderRepos.getOrdersContainProdID(prodId);
            return orders.stream()
                    .map(OrderMapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }
    }
}
