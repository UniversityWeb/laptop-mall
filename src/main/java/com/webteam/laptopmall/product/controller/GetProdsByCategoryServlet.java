package com.webteam.laptopmall.product.controller;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get-prods-by-category")
public class GetProdsByCategoryServlet extends HttpServlet {
    private ProdService prodService;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String category = req.getParameter("category");
        List<ProductDTO> prodDTDs = prodService.getProdsByCategory(getECategory(category));
        String url = "/WEB-INF/views/search.jsp";
        req.setAttribute("prods", prodDTDs);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private ECategory getECategory(String category){
        if (category.equals("laptop"))
            return ECategory.LAPTOP;
        if (category.equals("keyboard"))
            return ECategory.MECHANICAL_KEYBOARD;
        if (category.equals("monitor"))
            return ECategory.MONITOR;
        return null;
    }
}
