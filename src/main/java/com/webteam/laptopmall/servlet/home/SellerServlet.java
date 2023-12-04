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
        if(action.equals("Search")){
            String model = req.getParameter("model");
            model = model.trim();
            List<ProductDTO> prodDTDs = prodService.getProdsByModel("%" + model + "%");
            System.out.println(prodDTDs.size());
            req.setAttribute("prods", prodDTDs);
        } else if (action.equals("All")) {
            List<ProductDTO> prodDTDs = prodService.getAll();
            System.out.println(prodDTDs.size());
            req.setAttribute("prods", prodDTDs);
        } else if (action.equals("laptop")) {
            url = "/WEB-INF/views/seller-main-page.jsp";
        } else if (action.equals("keyboard")) {
            url = "/WEB-INF/views/seller-main-page.jsp";
        } else if (action.equals("monitor")) {
            url = "/WEB-INF/views/seller-main-page.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
}
