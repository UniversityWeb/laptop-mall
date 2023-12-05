package com.webteam.laptopmall.filter;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.service.user.UserService;
import com.webteam.laptopmall.service.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/api/salesperson/*"})
public class SalespersonFilter implements Filter {

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        userService = new UserServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession(false);

        if (isCustomer(session)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            redirectToAccessDeniedPage(httpRequest, httpResponse);
        }
    }

    private boolean isCustomer(HttpSession session) {
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (username != null) {
                User.ERole role = userService.getRoleByUsername(username);
                return role.equals(User.ERole.SALESPERSON);
            }
        }
        return false;
    }

    private void redirectToAccessDeniedPage(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws ServletException, IOException {
        String url = "/WEB-INF/views/access-denied.jsp";
        httpRequest.getServletContext().getRequestDispatcher(url).forward(httpRequest, httpResponse);
    }
}
