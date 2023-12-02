package com.webteam.laptopmall.servlet.history;

import com.webteam.laptopmall.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/WEB-INF/views/history/order-history.jsp";

        List<Order> ordersHistory = (List<Order>) req.getAttribute("ordersHistory");
        if(ordersHistory == null){
            ordersHistory = new ArrayList<>();
        }

        if (ordersHistory.size()<1){
            url = "/WEB-INF/views/history/order-history-empty.jsp";
        }

        req.setAttribute("ordersHistory", ordersHistory);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
