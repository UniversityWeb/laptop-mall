package com.webteam.laptopmall.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webteam.laptopmall.io.image.prod.ProdImgIO;
import com.webteam.laptopmall.io.image.prod.ProdImgIOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/api/image-urls")
public class GetImageUrlsOfProd extends HttpServlet {

    private static final Logger log = Logger.getLogger(GetImageUrlsOfProd.class.getName());
    private ProdImgIO prodImgIO;

    @Override
    public void init() throws ServletException {
        super.init();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prodIdStr = req.getParameter("prodId");
        Long prodId = Long.valueOf(prodIdStr);

        String realPath = getServletContext().getRealPath("/");
        List<String> imgUrls = prodImgIO.loadProdImageUrls(prodId, realPath);

        String jsonMsgs = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonMsgs = objectMapper.writeValueAsString(imgUrls);
        } catch (Exception e) {
            log.severe(e.getMessage());
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();
        pw.println(jsonMsgs);
        pw.close();
    }
}
