package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
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

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private CartService cartService;
    private UserService userService;
    private ProdImgIO prodImgIO;
    private static final Logger logger = Logger.getLogger(CartServlet.class.getName());

    @Override
    public void init() throws ServletException {
        super.init();
        cartService = new CartServiceImpl();
        userService = new UserServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/cart/check-cart.jsp";

        HttpSession session = req.getSession();

        String username = (String) session.getAttribute("username");
        UserDTO customer = userService.getByUsername(username);

        List<CartItemDTO> cart = cartService.getCartByUserId(customer.getId());

        if(cart == null || cart.size()<1) {
            url = "/home-page?cart=empty";
            resp.sendRedirect(req.getContextPath() + url);
        }
        else{

            String realPath = req.getServletContext().getRealPath("/");
            cart.forEach(cartItem -> cartItem.setProduct(prodImgIO.loadProdImageUrls(cartItem.getProduct(), realPath)));

            String totalDiscountedAmount = cartService.totalDiscountedAmountOfCartCurrentFormat(cart);
            String totalOriginalAmount = cartService.totalOriginalAmountOfCartCurrentFormat(cart);
            String totalDiscountAmount = cartService.totalDiscountAmountOfCartCurrentFormat(cart);
            int qtyItems = cartService.totalQtyOfCart(cart);
            req.setAttribute("totalDiscountedAmount", totalDiscountedAmount);
            req.setAttribute("totalOriginalAmount", totalOriginalAmount);
            req.setAttribute("totalDiscountAmount", totalDiscountAmount);
            req.setAttribute("qtyItems", qtyItems);
            req.setAttribute("cart", cart);
            getServletContext().getRequestDispatcher(url).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}