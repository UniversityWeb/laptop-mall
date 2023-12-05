package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.service.cart.CartService;
import com.webteam.laptopmall.service.cart.CartServiceImpl;
import com.webteam.laptopmall.service.user.UserService;
import com.webteam.laptopmall.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/delivery-infor")
public class DeliveryInforServlet extends HttpServlet {
    private CartService cartService;
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        cartService = new CartServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/cart/delivery-infor.jsp";

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserDTO customer = userService.getByUsername(username);
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());

        if (order == null) {
            order = new OrderDTO();
        }

        order.setCustomer(customer);
        session.setAttribute("customer", customer);
        session.setAttribute("order", order);

        String totalDiscountedAmount = cartService.totalDiscountedAmountOfCartCurrentFormat(cart);
        String totalOriginalAmount = cartService.totalOriginalAmountOfCartCurrentFormat(cart);
        String totalDiscountAmount = cartService.totalDiscountAmountOfCartCurrentFormat(cart);
        req.setAttribute("totalDiscountedAmount", totalDiscountedAmount);
        req.setAttribute("totalOriginalAmount", totalOriginalAmount);
        req.setAttribute("totalDiscountAmount", totalDiscountAmount);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
