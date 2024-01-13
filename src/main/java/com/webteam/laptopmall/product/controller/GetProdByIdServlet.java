package com.webteam.laptopmall.product.controller;

import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.ProductNotFoundException;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;
import com.webteam.laptopmall.user.service.UserService;
import com.webteam.laptopmall.user.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@MultipartConfig()
@WebServlet("/get-prod-by-id")
public class GetProdByIdServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(GetProdByIdServlet.class);

    private ProdService prodService;
    private ProdImgIO prodImgIO;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
        userService= new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = Long.valueOf(idStr);
        String realPath= req.getServletContext().getRealPath("/");

        String url;
        try {
            ProductDTO prodDTO = prodService.getById(id);
            prodDTO = prodImgIO.loadProdImageUrls(prodDTO, realPath);
            req.setAttribute("prod", prodDTO);
            url = "/WEB-INF/views/product-details.jsp";
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
            url = "/WEB-INF/views/access-denied.jsp";
        }

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserDTO user = userService.getByUsername(username);

        req.setAttribute("userRole", user.getRole());

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
