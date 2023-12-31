package com.webteam.laptopmall.servlet.statistical;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.Order;
import com.webteam.laptopmall.service.order.OrderService;
import com.webteam.laptopmall.service.order.OrderServiceImpl;
import com.webteam.laptopmall.service.prod.ProdService;
import com.webteam.laptopmall.service.prod.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

@WebServlet("/get-datas-chart")
public class GetDatasChart extends HttpServlet {
    private OrderService orderService;
    private ProdService prodService;
    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderServiceImpl();
        prodService = new ProdServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String selectedMonth = req.getParameter("selectedMonth");
        String selectedYear = req.getParameter("selectedYear");

        Integer month = Integer.valueOf(selectedMonth);
        Integer year = Integer.valueOf(selectedYear);

        String totalRevenue = orderService.getTotalRevenueByTime(month, year);
        Integer totalOrder = orderService.getNoOrderByTime(month, year);

        Gson gson = new Gson();

        String[] orderStatuses = orderService.convertListStatusToString(Order.EStatus.values());
        List<Integer> orderStatusValues = orderService.getValueByStatusAndTime(Order.EStatus.values(), month, year);

        String[] topBestSellProductsName = new String[10];
        String[] topLeastSellProductsName = new String[10];
        List<Integer> topBestSellProductsQty = new ArrayList<>();
        List<Integer> topLeastSellProductsQty = new ArrayList<>();

        orderService.setDataBestSellProductByTime(topBestSellProductsName, topBestSellProductsQty, month, year);
        orderService.setDataLeastSellProductByTime(topLeastSellProductsName, topLeastSellProductsQty, month, year);

        String jsonOrderStatuses = gson.toJson(orderStatuses);
        String jsonTopBestSellProductsName = gson.toJson(topBestSellProductsName);
        String jsonTopLeastSellProductsName = gson.toJson(topLeastSellProductsName);

        String url = "/WEB-INF/views/statistical.jsp";

        req.setAttribute("totalRevenue", totalRevenue);
        req.setAttribute("totalOrder", totalOrder);
        req.setAttribute("topLeastSellProductsName", jsonTopLeastSellProductsName);
        req.setAttribute("topLeastSellProductsQty", topLeastSellProductsQty);
        req.setAttribute("topBestSellProductsName", jsonTopBestSellProductsName);
        req.setAttribute("topBestSellProductsQty", topBestSellProductsQty);
        req.setAttribute("orderStatuses", jsonOrderStatuses);
        req.setAttribute("orderStatusValues", orderStatusValues);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
