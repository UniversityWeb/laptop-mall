package com.webteam.laptopmall.user.controller.home;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home-page")
public class HomeServlet extends HttpServlet {

    private UserService userService;

    private ProdService prodService;

    private ProdImgIO prodImgIO;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        User.ERole role = userService.getRoleByUsername(username);
        String realPath = req.getServletContext().getRealPath("/");
        String url = getUrlByRole(role);

        if(role == User.ERole.SALESPERSON){
            List<ProductDTO> prodDTOs = prodService.getProdsIsAvailable();
            prodDTOs.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
            req.setAttribute("prods", prodDTOs);
        }
        else {
            List<ProductDTO> laptops= prodService.getProdsByCategory(ECategory.LAPTOP);
            List<ProductDTO> keyboards= prodService.getProdsByCategory(ECategory.MECHANICAL_KEYBOARD);
            List<ProductDTO> monitors= prodService.getProdsByCategory(ECategory.MONITOR);
            laptops.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
            monitors.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
            keyboards.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
            req.setAttribute("laptops",getNumberProdsDTO(laptops,20));
            req.setAttribute("keyboards",getNumberProdsDTO(keyboards,20));
            req.setAttribute("monitors",getNumberProdsDTO(monitors,20));
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private String getUrlByRole(User.ERole role) {
        String url;
        if (role == User.ERole.SALESPERSON) {
            url = "/WEB-INF/views/seller-main-page.jsp";
        } else if (role == User.ERole.CUSTOMER) {
            url = "/WEB-INF/views/customer-main-page.jsp";
        } else {
            url = "/WEB-INF/views/access-denied.jsp";
        }
        return url;
    }

    private List<ProductDTO> getNumberProdsDTO(List<ProductDTO> prods,int number){
        if (prods.size() < number)
            return prods;
        return prods.subList(0,number);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
