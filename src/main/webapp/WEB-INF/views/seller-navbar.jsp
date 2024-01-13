<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/navbar.css"/>" type="text/css">
</head>
<body>
<nav class="navbar-main">
    <img class="navbar-logo" src="<c:url value="/static/images/logo.svg"/>" alt="logo">
    <ul class="navbar-list">
        <li class="navbar-item">
            <div class="button-inner btn-obj">
                <b class="btn-txt">Products</b>
            </div>
        </li>
    </ul>
    <div class="nav__list-icon" >
        <div class="navbar-menu-container" style="display: none;">
            <img id="nav-list-btn"  src="<c:url value="/static/images/list-btn.svg"/>" >
            <ul id="nav-menu" class="navbar-menu">
                <li class="navbar__menu-item">
                    <p>Product Management</p>
                </li>
            </ul>
        </div>
        <form action="home-page" method="get">
            <button type="submit" class="nav__btn-icon">
                <i class="fa-solid fa-house hover_icon"></i>
            </button>
        </form>
        <form action="statistical" method="get">
            <button type="submit" class="nav__btn-icon">
                <i class="fa-solid fa-chart-simple hover_icon"></i>
            </button>
        </form>
        <form action="<%= contextPath %>/seller-orders" method="get">
            <button type="submit" class="nav__btn-icon">
                <i class="fa-solid fa-rectangle-list hover_icon"></i>
            </button>
        </form>
        <form action="<%= contextPath %>/chat/salesperson" method="get">
            <button type="submit" class="nav__btn-icon hover_icon">
                <i class="fa-solid fa-comment hover_icon"></i>
            </button>
        </form>
        <form action="<%= contextPath %>/user-profile" method="get">
            <button type="submit" class="nav__btn-icon hover_icon">
                <i class="fa-solid fa-user"></i>
            </button>
        </form>
        <form action="<%= contextPath %>/logout" method="post">
            <button type="submit" class="nav__btn-icon ">
                <i class="fa-solid fa-right-from-bracket hover_icon" ></i>
            </button>
        </form>
    </div>
</nav>
</body>
</html>
