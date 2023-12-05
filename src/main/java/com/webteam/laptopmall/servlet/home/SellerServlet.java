package com.webteam.laptopmall.servlet.home;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
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
    private ProdImgIO prodImgIO;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String realPath = req.getServletContext().getRealPath("/");
        String url = "/WEB-INF/views/seller-main-page.jsp";
        String action = req.getParameter("action");

        if (action == null)
            action = "All";

        if(action.equals("Search")){
            String model = req.getParameter("model");
            model = model.trim();
            List<ProductDTO> prodDTOs = prodService.getProdsByModel("%" + model + "%");
            prodDTOs.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
            req.setAttribute("prods", prodDTOs);
        } else if (action.equals("All")) {
            List<ProductDTO> prodDTOs = prodService.getAll();
            prodDTOs.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
            req.setAttribute("prods", prodDTOs);
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
}
