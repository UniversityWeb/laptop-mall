package com.webteam.laptopmall.servlet.cart.crud;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.service.cart.CartService;
import com.webteam.laptopmall.service.cart.CartServiceImpl;
import com.webteam.laptopmall.service.cartItem.CartItemService;
import com.webteam.laptopmall.service.cartItem.CartItemServiceImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;
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
import java.util.logging.Logger;

@WebServlet("/add-cart")
public class AddItemServlet extends HttpServlet {

    private ProdService prodService;
    private CartService cartService;
    private UserService userService;
    private CartItemService cartItemService;
    private static final Logger logger = Logger.getLogger(AddItemServlet.class.getName());

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        cartService = new CartServiceImpl();
        userService = new UserServiceImpl();
        cartService = new CartServiceImpl();
        cartItemService = new CartItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/home-page";

        HttpSession session = req.getSession();
        UserDTO customer = (UserDTO) session.getAttribute("customer");
        if (customer == null){
            UserDTO user = (UserDTO) session.getAttribute("user");
            customer = userService.getByUsername(user.getUsername());
        }

        Long productId = (Long) req.getAttribute("productId");

        try{
            ProductDTO product = prodService.getById(productId);
            List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());

            if(cart == null){
                cart = new ArrayList<>();
            }

            CartItemDTO cartItem = new CartItemDTO(1, customer, product);
            cartService.addItem(cart, cartItem);
            url = "/cart";
        } catch (Exception e){
            logger.severe(e.getMessage());
        }

        session.setAttribute("customer", customer);
        resp.sendRedirect(req.getContextPath() + url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
