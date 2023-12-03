package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.service.cart.CartService;
import com.webteam.laptopmall.service.cart.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/payment-method")
public class PaymentMethodServlet extends HttpServlet {
    private CartService cartService;
    @Override
    public void init() throws ServletException {
        super.init();
        cartService = new CartServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/cart/payment-method.jsp";
        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        System.out.println(order.getCustomer());
        List<CartItemDTO> cart = cartService.getCartByUserId(order.getCustomer().getId());

        String totalDiscountedAmount = cartService.totalDiscountedAmountOfCartCurrentFormat(cart);
        String totalOriginalAmount = cartService.totalOriginalAmountOfCartCurrentFormat(cart);
        String totalDiscountAmount = cartService.totalDiscountAmountOfCartCurrentFormat(cart);
        req.setAttribute("totalDiscountedAmount", totalDiscountedAmount);
        req.setAttribute("totalOriginalAmount", totalOriginalAmount);
        req.setAttribute("totalDiscountAmount", totalDiscountAmount);

        req.setAttribute("cart", cart);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
