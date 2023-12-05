package com.webteam.laptopmall.servlet.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;
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
import java.util.List;
@MultipartConfig()
@WebServlet("/get-prods-by-model")
public class GetProdsByModelServlet extends HttpServlet {

    private ProdService prodService;
    private ProdImgIO prodImgIO;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String realPath = req.getServletContext().getRealPath("/");
        String model = req.getParameter("model");
        model = model.trim();
        List<ProductDTO> prodDTOs = prodService.getProdsByModel("%" + model + "%");
        prodDTOs.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
        String url = "/WEB-INF/views/search.jsp";
        req.setAttribute("prods", prodDTOs);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
