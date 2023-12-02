package com.webteam.laptopmall.servlet.cart.crud;

import com.webteam.laptopmall.dto.CartItemDTO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/delete")
public class DeleteItemServlet extends HttpServlet {
    private CartService cartService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        cartService = new CartServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/cart";

        HttpSession session = req.getSession();
        UserDTO customer = (UserDTO) session.getAttribute("customer");
        List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());

        Long productId = (Long) session.getAttribute("productId");
        String action = req.getParameter("action");

        if(action.equals("Remove Item")){
            cartService.deleteItemByProductId(cart, productId);
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
