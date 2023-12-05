package com.webteam.laptopmall.servlet.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/get-all-prods")
public class GetProdsServlet extends HttpServlet {

    private ProdService prodService;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<ProductDTO> prodDTOs = prodService.getAll();
        PrintWriter pw = resp.getWriter();
        pw.println(prodDTOs);
    }
}
