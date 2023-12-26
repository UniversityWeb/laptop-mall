package com.webteam.laptopmall.servlet.statistical;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet("/statistical")
public class StatisticalServlet extends HttpServlet {
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
        String selectedMonth = req.getParameter("selectedMonth");
        String selectedYear = req.getParameter("selectedYear");

        if (selectedMonth == null){
                selectedMonth = String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);
        }
        if (selectedYear == null){
            selectedYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        }

        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String url = "/get-datas-chart?selectedMonth=" + selectedMonth + "&selectedYear=" + selectedYear;

        req.setAttribute("selectedMonth", selectedMonth);
        req.setAttribute("selectedYear", selectedYear);
        req.setAttribute("monthNames", monthNames);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
