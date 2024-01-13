package com.webteam.laptopmall.order.controller.seller;

import com.webteam.laptopmall.order.OrderDTO;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.order.Order;
import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.order.service.OrderService;
import com.webteam.laptopmall.order.service.OrderServiceImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/seller-orders")
public class SellerOrdersServlet extends HttpServlet {
    private OrderService orderService;
    private UserService userService;
    private ProdImgIO prodImgIO;
    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/seller-orders.jsp";

        HttpSession session = req.getSession();
        String tab = req.getParameter("tab");
        String realPath = req.getServletContext().getRealPath("/");
        List<UserDTO> customers = userService.getAll();
        if (tab == null){
            tab = "ALL";
        }

        List<OrderDTO> orders = new ArrayList<>();
        if (tab.equals("ALL")){
            orders = orderService.getALl();
            orders.forEach(order -> order.getOrderItems().forEach(orderItem -> orderItem.setProduct(prodImgIO.loadProdImageUrls(orderItem.getProduct(), realPath))));
        }
        else {
            for (UserDTO u : customers) {
                if (u.getRole().equals(User.ERole.CUSTOMER))
                {
                    List<OrderDTO> orderDTOS = orderService.getListByUserIdAndStatus(u.getId(), Order.EStatus.valueOf(tab));
                    if(orderDTOS!=null)
                        orders.addAll(orderDTOS);
                }
            }
            orders.forEach(order -> order.getOrderItems().forEach(orderItem -> orderItem.setProduct(prodImgIO.loadProdImageUrls(orderItem.getProduct(), realPath))));
        }
        if (orders.size()<1){
            url = "/WEB-INF/views/seller-order-empty.jsp";
        }
        req.setAttribute("ordersHistory", orders);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
