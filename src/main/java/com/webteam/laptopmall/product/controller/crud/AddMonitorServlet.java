package com.webteam.laptopmall.product.controller.crud;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.MonitorDTO;
import com.webteam.laptopmall.product.entity.Monitor;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.product.controller.GetProdByIdServlet;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add-monitor")
public class AddMonitorServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(GetProdByIdServlet.class);

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

        MonitorDTO product = new MonitorDTO();
        product.setCategory(ECategory.MONITOR);
        log.info(product.toString());
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
