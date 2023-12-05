<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="nav__list-icon">
        <div class="navbar-menu-container">
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
        <form action="chat/salesperson" method="get">
            <button type="submit" class="nav__btn-icon">
                <i class="fa-solid fa-messages hover_icon"></i>
            </button>
        </form>
        <form action="/" method="post">
            <button type="submit" class="nav__btn-icon hover_icon">
                <i class="fa-solid fa-user"></i>
            </button>
        </form>
    </div>
</nav>
</body>
</html>
