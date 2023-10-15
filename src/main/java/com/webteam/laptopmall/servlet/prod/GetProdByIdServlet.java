package com.webteam.laptopmall.servlet.prod;

import com.webteam.laptopmall.dto.ProductDTO;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-prod-by-id")
public class GetProdByIdServlet extends HttpServlet {

    private ProdService prodService;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = new Long(idStr);

        ProductDTO prodDTO = prodService.getById(id);
        PrintWriter pw = resp.getWriter();
        pw.println(prodDTO);
    }
}
