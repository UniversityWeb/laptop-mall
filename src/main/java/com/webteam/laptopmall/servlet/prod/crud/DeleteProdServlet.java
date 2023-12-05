package com.webteam.laptopmall.servlet.prod.crud;

import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-prod")
public class DeleteProdServlet extends HttpServlet {
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
        String url = "/WEB-INF/views/seller-main-page.jsp";
        String prodIdStr = req.getParameter("prodID");
        Long prodId = Long.valueOf(prodIdStr);

        String readPath = getServletContext().getRealPath("/");

        prodService.deleteById(prodId);
        prodImgIO.deleteAllWithoutDefault(readPath, prodId);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
