package com.webteam.laptopmall.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/login", "/register"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        if (isGetRequest(httpRequest) && isUserLoggedIn(httpRequest)) {
            redirectToHomePage(httpRequest, httpResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isGetRequest(HttpServletRequest request) {
        return "GET".equalsIgnoreCase(request.getMethod());
    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("username") != null;
    }

    private void redirectToHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getContextPath() + "/home-page";
        response.sendRedirect(url);
    }
}
