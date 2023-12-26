package com.webteam.laptopmall.servlet.prod.crud;

import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
import com.webteam.laptopmall.service.order.OrderService;
import com.webteam.laptopmall.service.order.OrderServiceImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;
import com.webteam.laptopmall.servlet.prod.GetProdByIdServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/delete-prod")
public class DeleteProdServlet extends HttpServlet {
    private ProdService prodService;
    private ProdImgIO prodImgIO;
    private OrderService orderService;
    private static final Logger log = Logger.getLogger(GetProdByIdServlet.class.getName());

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "/WEB-INF/views/seller-main-page.jsp";
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        boolean isSuccessful = false;
        String realPath = req.getServletContext().getRealPath("/");
        Long prodId = Long.valueOf(req.getParameter("prodID"));

        try {
            List<OrderDTO> orderDTOS = orderService.getOrdersContainProdID(prodId);
            for (OrderDTO o: orderDTOS) {
                if(o.getStatus().equals(Order.EStatus.PENDING)){
                    o.setStatus(Order.EStatus.CANCELLED);
                    orderService.update(o);
                }
            }

            prodService.markProductAsDeleted(prodId);
            isSuccessful=true;

        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }

        List<ProductDTO> prodDTOs = prodService.getProdsIsAvailable();
        prodDTOs.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
        req.setAttribute("prods", prodDTOs);
        req.setAttribute("isSuccessful",isSuccessful);
        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
