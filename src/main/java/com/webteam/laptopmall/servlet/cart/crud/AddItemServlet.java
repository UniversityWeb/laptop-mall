package com.webteam.laptopmall.servlet.cart.crud;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.service.cart.CartService;
import com.webteam.laptopmall.service.prod.ProdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-cart")
public class AddItemServlet extends HttpServlet {

    private ProdService prodService;
    private CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/home";

        HttpSession session = req.getSession();

        Long productId = (Long) session.getAttribute("productId");
        ProductDTO product = prodService.getById(productId);
        
        if(product != null) {
            List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
            if(cart == null){
                cart = new ArrayList<>();
        }
            UserDTO customer = new UserDTO();
            CartItemDTO cartItem = new CartItemDTO(1, customer, product);
            cartService.addItem(cart, cartItem);
            url = "/cart";
            req.setAttribute("cart", cart);
            resp.sendRedirect(url);
            return;
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
