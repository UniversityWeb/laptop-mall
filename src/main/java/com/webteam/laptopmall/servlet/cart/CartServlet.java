package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private CartService cartService;
    private UserService userService;
    private static final Logger logger = Logger.getLogger(CartServlet.class.getName());

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

        String url = "/WEB-INF/views/cart/check-cart.jsp";
        String message = "";

        HttpSession session = req.getSession();

        UserDTO user = (UserDTO) session.getAttribute("user");
        UserDTO customer = userService.getByUsername(user.getUsername());
        List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());

        if(cart == null || cart.size()<1) {
            message = "Cart is empty";
            logger.info("Cart is empty!");
            url = "/home-page";
        }
        else{
            BigDecimal totalDiscountedAmount = cartService.totalDiscountedAmountOfCart(cart);
            BigDecimal totalOriginalAmount = cartService.totalOriginalAmountOfCart(cart);
            BigDecimal totalDiscountAmount = cartService.totalDiscountAmountOfCart(cart);
            int qtyItems = cartService.totalQtyOfCart(cart);

            req.setAttribute("totalDiscountedAmount", totalDiscountedAmount);
            req.setAttribute("totalOriginalAmount", totalOriginalAmount);
            req.setAttribute("totalDiscountAmount", totalDiscountAmount);
            req.setAttribute("qtyItems", qtyItems);
            session.setAttribute("customer", customer);
            session.setAttribute("cart", cart);
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}