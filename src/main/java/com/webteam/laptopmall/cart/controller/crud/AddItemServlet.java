package com.webteam.laptopmall.cart.controller.crud;

import com.webteam.laptopmall.cartitem.CartItemDTO;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.cart.service.CartService;
import com.webteam.laptopmall.cart.service.CartServiceImpl;
import com.webteam.laptopmall.cartitem.service.CartItemService;
import com.webteam.laptopmall.cartitem.service.CartItemServiceImpl;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-cart-item")
public class AddItemServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(AddItemServlet.class);

    private ProdService prodService;
    private CartService cartService;
    private UserService userService;
    private CartItemService cartItemService;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/home-page";

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserDTO customer = userService.getByUsername(username);

        List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());
        String productIdString = req.getParameter("productId");
        String qtyString = req.getParameter("qty");

        try{
            Long productId = Long.valueOf(productIdString);
            ProductDTO product = prodService.getById(productId);
            int qty;
            try{
                qty = Integer.valueOf(qtyString);
                if(qty <= 0){
                    qty = 1;
                }
            } catch (NumberFormatException e){
                qty = 1;
                log.error(e.getMessage());
            }
            CartItemDTO cartItem = new CartItemDTO(qty, customer, product);
            cartService.addItem(cartItem);
            url = "/cart";
        } catch (Exception e){
            log.error(e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + url);
    }
}
