package com.webteam.laptopmall.servlet.cart.crud;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.service.cart.CartService;
import com.webteam.laptopmall.service.prod.ProdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/update")
public class UpdateItemServlet extends HttpServlet {

    private ProdService prodService;
    private CartService cartService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/cart";

        HttpSession session = req.getSession();
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");

        String action = req.getParameter("action");

        Long productId = (Long) session.getAttribute("productId");
        ProductDTO product = prodService.getById(productId);
        CartItemDTO cartItem = new CartItemDTO();

        for (CartItemDTO item: cart) {
            if(item.getProduct().getId().equals(productId)){
                cartItem = item;
                break;
            }
        }

        if(action.equals("") || action.isEmpty()){
            String quantityString =  (String) session.getAttribute("quantity");
            int quantity;

            try{
                quantity = Integer.valueOf(quantityString);
                if(quantity < 0) {
                    quantity = cartItem.getQty();
                }
            }catch (NumberFormatException e){
                quantity = cartItem.getQty();
            }

            cartService.updateItem(cart, cartItem);
        }
        else{
            if(action.equals("Add Item")){
                cartItem.setQty(1);
            }
            else if (action.equals("Minus Item")){
                cartItem.setQty(-1);
            }
            else{
                cartItem.setQty(0);
            }
            cartService.addItem(cart, cartItem);
        }

        req.setAttribute("cart", cart);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
