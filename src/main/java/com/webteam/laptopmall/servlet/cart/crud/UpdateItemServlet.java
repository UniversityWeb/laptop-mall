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
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/update")
public class UpdateItemServlet extends HttpServlet {
    private CartService cartService;
    private UserService userService;

    private static final Logger logger = Logger.getLogger(UpdateItemServlet.class.getName());

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

        String buttonUpdate = req.getParameter("buttonUpdate");
        Long productId = (Long) req.getAttribute("productId");

        CartItemDTO cartItem = cartService.getItemOfCartById(cart, productId);

        if(buttonUpdate.equals("") || buttonUpdate == null){
            String quantityString = req.getParameter("quantity");

            int quantity;
            try{
                quantity = Integer.valueOf(quantityString);
                if (quantity < 0){
                    quantity = 1;
                }
            } catch (NumberFormatException e){
                quantity = cartItem.getQty();
                logger.severe("ERROR: " + e.getMessage());
            }

            cartItem.setQty(quantity);
            cartService.updateItem(cart, cartItem);
        }
        else{
            int quantity;
            try{
                quantity = Integer.valueOf(buttonUpdate);
            } catch (NumberFormatException e){
                quantity = 0;
                logger.severe("ERROR: " + e.getMessage());
            }

            cartItem.setQty(quantity);
            cartService.addItem(cart, cartItem);
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
