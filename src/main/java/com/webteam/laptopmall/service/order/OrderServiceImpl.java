package com.webteam.laptopmall.service.order;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.OrderItemDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.mapper.OrderMapper;
import com.webteam.laptopmall.mapper.OrderMapperImpl;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.repository.cartitem.CartItemReposImpl;
import com.webteam.laptopmall.repository.order.OrderRepos;
import com.webteam.laptopmall.repository.order.OrderReposImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService{
    private OrderRepos orderRepos;
    private OrderMapper orderMapper;

    private CartItemRepos cartItemRepos;

    public OrderServiceImpl(){
        orderRepos = new OrderReposImpl();
        orderMapper = new OrderMapperImpl();
        cartItemRepos = new CartItemReposImpl();
    }

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

    @Override
    public String getMailBody(OrderDTO orderDTO) {
        UserDTO customer = orderDTO.getCustomer();

        String listItem = "";
        for (OrderItemDTO orderItemDTO: orderDTO.getOrderItems()) {
            listItem += "<td><div style='width: 50px; height: 50px; object-fit: cover; overflow: hidden;'>" +
                    "<img src='" + orderItemDTO.getProduct().getModel() +"' alt='product images' style='width: 100%; height: auto;'>" +
                    "</div></td>" +
                    "<td style='width: 150px; overflow: auto;'>" + orderItemDTO.getProduct().getModel() +"</td>" +
                    "<td style='width: 50px; overflow: auto;'>"+ orderItemDTO.getProduct().getColor() +"</td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'> x"+ orderItemDTO.getQty() +"</td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'><del>"+ orderItemDTO.getProduct().getPrice() +"</del></td>" +
                    "<td style='width: 100px; overflow: auto; text-align: right'>" + orderItemDTO.getCurPrice() +"</td>";
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
                "<p><strong>Order ID:"+ orderDTO.getId() +"</strong></p>" +
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
                + listItem + "<tr style='margin: 10px 0px;'><td>&nbsp;</td><td>&nbsp;</td>" +
                "<td>Total:</td><td style='width: 100px; overflow: auto; text-align: right'>&nbsp;</td>" +
                "<td style='width: 100px; overflow: auto; text-align: right'>&nbsp;</td>" +
                "<td style='width: 100px; overflow: auto; text-align: right;'>"+orderDTO.totalDiscountedAmountOfOrderCurrentFormat()+"</td></tr></table>" +
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
}
