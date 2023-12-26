package com.webteam.laptopmall.servlet.prod.crud;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.MechanicalKeyboardDTO;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;
import com.webteam.laptopmall.servlet.prod.GetProdByIdServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/add-keyboard")
public class AddKeyboardServlet extends HttpServlet {
    private ProdService prodService;
    private ProdImgIO prodImgIO;
    private static final Logger log = Logger.getLogger(GetProdByIdServlet.class.getName());
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

        MechanicalKeyboardDTO product = new MechanicalKeyboardDTO();
        product.setCategory(ECategory.MECHANICAL_KEYBOARD);
        List<ECategory> eCategories= List.of(ECategory.values());
        List<MechanicalKeyboard.EConnection> eConnections= List.of(MechanicalKeyboard.EConnection.values());
        List<MechanicalKeyboard.ELayout> eLayouts= List.of(MechanicalKeyboard.ELayout.values());
        List<Laptop.EOS> eosList= List.of(Laptop.EOS.values());
        req.setAttribute("product", product);
        req.setAttribute("eCategories", eCategories);
        req.setAttribute("eConnections", eConnections);
        req.setAttribute("eLayouts", eLayouts);
        req.setAttribute("eosList", eosList);


        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

}
