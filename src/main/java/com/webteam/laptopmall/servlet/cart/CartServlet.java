package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.service.cart.CartService;

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

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private CartService cartService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/cart/check-cart.jsp";

        HttpSession session = req.getSession();
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<>();
        }

        if(cart.size()>0) {
            BigDecimal totalDiscountedAmount = cartService.totalDiscountedAmountOfCart(cart);
            BigDecimal totalOriginalAmount = cartService.totalOriginalAmountOfCart(cart);
            BigDecimal totalDiscountAmount = cartService.totalDiscountAmountOfCart(cart);

            req.setAttribute("totalDiscountedAmount", totalDiscountedAmount);
            req.setAttribute("totalOriginalAmount", totalOriginalAmount);
            req.setAttribute("totalDiscountAmount", totalDiscountAmount);
        }

        session.setAttribute("cart", cart);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}