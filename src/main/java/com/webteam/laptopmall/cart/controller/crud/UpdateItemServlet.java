package com.webteam.laptopmall.cart.controller.crud;

import com.webteam.laptopmall.cartitem.CartItemDTO;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.cart.service.CartService;
import com.webteam.laptopmall.cart.service.CartServiceImpl;
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

@WebServlet("/update-cart-item")
public class UpdateItemServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(UpdateItemServlet.class);

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

        String url = "/cart";

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserDTO customer = userService.getByUsername(username);

        List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());

        String action = req.getParameter("action");

        if (action == null){
            action = "";
        }

        String productIdString = req.getParameter("productId");
        Long productId = Long.valueOf(productIdString);
        int qty;

        CartItemDTO cartItem = cartService.getItemOfCartById(cart, productId);

        if(action.equals("increase")){
            qty = cartItem.getQty() + 1;
        }
        else if (action.equals("decrease")){
            qty = cartItem.getQty() - 1;
            if (qty <= 0){
                cartService.deleteItem(cartItem);
            }
        }
        else{
            String qtyString = req.getParameter("qty");
            System.out.println(qtyString);
            try{
                qty = Integer.valueOf(qtyString);
                if (qty < 0){
                    qty = 1;
                }
            } catch (NumberFormatException e){
                qty = cartItem.getQty();
                log.error("ERROR: " + e.getMessage());
            }
        }

        cartItem.setQty(qty);
        cartService.updateQtyOnly(cartItem);

        resp.sendRedirect(req.getContextPath() + url);
    }
}
