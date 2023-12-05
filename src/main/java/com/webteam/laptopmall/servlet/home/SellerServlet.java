package com.webteam.laptopmall.servlet.home;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/seller-main-page")
public class SellerServlet extends HttpServlet {
    private ProdService prodService;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/seller-main-page.jsp";
        String action = req.getParameter("action");

        if (action == null)
            action = "All";

        if(action.equals("Search")){
            String model = req.getParameter("model");
            model = model.trim();
            List<ProductDTO> prodDTDs = prodService.getProdsByModel("%" + model + "%");
            req.setAttribute("prods", prodDTDs);
        } else if (action.equals("All")) {
            List<ProductDTO> prodDTDs = prodService.getAll();
            req.setAttribute("prods", prodDTDs);
        } else if (action.equals("New")) {
            Long prodID = prodService.createNewProdID();
            req.setAttribute("prodID",prodID);
            url = "/WEB-INF/views/product-input.jsp";
        } else if (action.equals("Update")) {
            Long prodID = Long.valueOf(req.getParameter("prodID"));
            req.setAttribute("prodID",prodID);
            url = "/WEB-INF/views/product-input.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
}
