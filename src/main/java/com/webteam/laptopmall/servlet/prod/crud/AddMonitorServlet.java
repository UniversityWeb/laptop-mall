package com.webteam.laptopmall.servlet.prod.crud;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.MonitorDTO;
import com.webteam.laptopmall.entity.prod.Monitor;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-monitor")
public class AddMonitorServlet extends HttpServlet {
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

        MonitorDTO product = new MonitorDTO();
        product.setCategory(ECategory.MONITOR);
        log.log(Level.SEVERE, product.toString());
        List<ECategory> eCategories= List.of(ECategory.values());
        List<Monitor.EPanel> ePanels= List.of(Monitor.EPanel.values());
        List<Monitor.EConnection> eConnections= List.of(Monitor.EConnection.values());
        req.setAttribute("product", product);
        req.setAttribute("eCategories", eCategories);
        req.setAttribute("eConnections", eConnections);
        req.setAttribute("ePanels", ePanels);

        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
