package com.webteam.laptopmall.product.controller.crud;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.entity.Laptop;
import com.webteam.laptopmall.product.entity.MechanicalKeyboard;
import com.webteam.laptopmall.product.entity.Monitor;
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

@WebServlet("/update-prod")
public class UpdateProdServlet extends HttpServlet {
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
        String prodID = req.getParameter("prodID");
        ProductDTO product = prodService.getById(Long.valueOf(prodID));
        List<ECategory> eCategories= List.of(ECategory.values());

        if (product.getCategory().equals(ECategory.LAPTOP))
        {
            List<Laptop.ERam> eRams= List.of(Laptop.ERam.values());
            List<Laptop.ERom> eRoms= List.of(Laptop.ERom.values());
            List<Laptop.EOS> eosList= List.of(Laptop.EOS.values());
            req.setAttribute("eRams", eRams);
            req.setAttribute("eRoms", eRoms);
            req.setAttribute("eosList", eosList);
        } else if (product.getCategory().equals(ECategory.MECHANICAL_KEYBOARD)) {
            List<MechanicalKeyboard.EConnection> eConnections= List.of(MechanicalKeyboard.EConnection.values());
            List<MechanicalKeyboard.ELayout> eLayouts= List.of(MechanicalKeyboard.ELayout.values());
            List<Laptop.EOS> eosList= List.of(Laptop.EOS.values());
            req.setAttribute("eConnections", eConnections);
            req.setAttribute("eLayouts", eLayouts);
            req.setAttribute("eosList", eosList);
        } else if (product.getCategory().equals(ECategory.MONITOR)) {
            List<Monitor.EPanel> ePanels= List.of(Monitor.EPanel.values());
            List<Monitor.EConnection> eConnections= List.of(Monitor.EConnection.values());
            req.setAttribute("eConnections", eConnections);
            req.setAttribute("ePanels", ePanels);
        }

        String realPath= req.getServletContext().getRealPath("/");
        product = prodImgIO.loadProdImageUrls(product, realPath);

        req.setAttribute("product", product);
        req.setAttribute("eCategories", eCategories);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
