package com.webteam.laptopmall.servlet.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.exception.ProductNotFoundException;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@MultipartConfig()
@WebServlet("/get-prod-by-id")
public class GetProdByIdServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GetProdByIdServlet.class.getName());
    private ProdService prodService;
    private ProdImgIO prodImgIO;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = Long.valueOf(idStr);
        String realPath= req.getServletContext().getRealPath("/");

        String url;
        try {
            ProductDTO prodDTO = prodService.getById(id);
            prodDTO = prodImgIO.loadProdImageUrls(prodDTO, realPath);
            req.setAttribute("prod", prodDTO);
            url = "/WEB-INF/views/product-details.jsp";
        } catch (ProductNotFoundException e) {
            log.log(Level.SEVERE, e.getMessage());
            url = "/WEB-INF/views/access-denied.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
