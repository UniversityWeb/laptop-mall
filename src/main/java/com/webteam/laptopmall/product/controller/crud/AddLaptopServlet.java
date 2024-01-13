package com.webteam.laptopmall.product.controller.crud;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.LaptopDTO;
import com.webteam.laptopmall.product.entity.Laptop;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-laptop")
public class AddLaptopServlet extends HttpServlet {
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
        String url = "/WEB-INF/views/product-input.jsp";
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        LaptopDTO product = new LaptopDTO();
        product.setCategory(ECategory.LAPTOP);
        List<ECategory> eCategories= List.of(ECategory.values());
        List<Laptop.ERam> eRams= List.of(Laptop.ERam.values());
        List<Laptop.ERom> eRoms= List.of(Laptop.ERom.values());
        List<Laptop.EOS> eosList= List.of(Laptop.EOS.values());
        req.setAttribute("product", product);
        req.setAttribute("eCategories", eCategories);
        req.setAttribute("eRams", eRams);
        req.setAttribute("eRoms", eRoms);
        req.setAttribute("eosList", eosList);

        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
