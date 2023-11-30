package com.webteam.laptopmall.servlet.cart;

import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.dto.OrderDTO;
import com.webteam.laptopmall.dto.user.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check-information")
public class CheckInforServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = "/method-delivery";

        HttpSession session = req.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        UserDTO customer = (UserDTO) session.getAttribute("customer");
        if(order == null){
            order = new OrderDTO();
        }

        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String gender = req.getParameter("gender");
        String deliveryMethod = req.getParameter("deliveryMethod");
        String phoneNo = req.getParameter("phoneNo");
        String address = req.getParameter("address");
        String note = req.getParameter("note");

        customer = new UserDTO(address, email, fullName, phoneNo);
        order.setDeliveryMethod(deliveryMethod);
        order.setNote(note);

        if (gender != null && gender != ""){
            customer.setGender(EGender.valueOf(gender));
        }

        if(customer.getAddress() == "" || customer.getAddress() == null
                || customer.getEmail() == "" || customer.getEmail().isEmpty()
                || customer.getFullName() == "" || customer.getFullName().isEmpty()
                || customer.getGender() == null || customer.getPhoneNo() == ""
                || customer.getPhoneNo().isEmpty() || order.getDeliveryMethod() == ""
                || order.getDeliveryMethod() == null){
            url = "/check-information";
        }
        else{
            order.setCustomer(customer);
        }

        session.setAttribute("customer", customer);
        session.setAttribute("order", order);
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
