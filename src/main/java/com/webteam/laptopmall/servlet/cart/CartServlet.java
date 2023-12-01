package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.service.cart.CartService;
import com.webteam.laptopmall.service.cart.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private CartService cartService;
    private static final Logger logger = Logger.getLogger(CartServlet.class.getName());

    @Override
    public void init() throws ServletException {
        super.init();
        cartService = new CartServiceImpl();
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
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");

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
            session.setAttribute("cart", cart);
        }

        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}