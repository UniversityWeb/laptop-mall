package com.webteam.laptopmall.servlet.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.exception.ProductNotFoundException;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/get-prod-by-id")
public class GetProdByIdServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GetProdByIdServlet.class.getName());
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
        Long id = Long.valueOf(idStr);

        String url;
        try {
            ProductDTO prodDTO = prodService.getById(id);
            req.setAttribute("prod", prodDTO);
            url = "/WEB-INF/views/product-details.jsp";
        } catch (ProductNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
            url = "/WEB-INF/views/access-denied.html";
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
