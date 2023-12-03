<%--
  Created by IntelliJ IDEA.
  User: TRUONG AN
  Date: 10/27/2023
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link href="<c:url value="/static/images/logo.svg"/>" rel="icon"/>
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
        <b class="btn-txt">Sales</b>
      </div>
    </li>
    <li class="navbar-item">
      <div class="button-inner btn-obj">
        <b class="btn-txt">Laptop</b>
      </div>
    </li>
    <li class="navbar-item">
      <div class="button-inner btn-obj">
        <b class="btn-txt">Keyboard</b>
      </div>
    </li>
    <li class="navbar-item">
      <div class="button-inner btn-obj">
        <b class="btn-txt">Monitor</b>
      </div>
    </li>
    <li class="navbar-item">
      <div class="button-inner btn-obj">
        <b class="btn-txt">Suports</b>
      </div>
    </li>
  </ul>
  <div class="nav__list-icon">
    <div class="navbar-menu-container">
      <img id="nav-list-btn"  src="<c:url value="/static/images/list-btn.svg"/>" >
      <ul id="nav-menu" class="navbar-menu">
        <li class="navbar__menu-item">
          <p>Sales</p>
        </li>
        <li class="navbar__menu-item">
          <p>Laptop</p>
        </li>
        <li class="navbar__menu-item">
          <p>Keyboard</p>
        </li>
        <li class="navbar__menu-item">
          <p>Accessory</p>
        </li>
        <li class="navbar__menu-item">
          <p>Support</p>
        </li>
      </ul>
    </div>
    <button class="nav__btn-icon" onclick="openModalSearch()">
      <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
    </button>
    <form action="cart" method="post">
      <button type="submit" class="nav__btn-icon">
        <i class="fa-solid fa-cart-shopping hover_icon" ></i>
      </button>
    </form>
    <form action="/" method="post">
      <button type="submit" class="nav__btn-icon hover_icon">
        <i class="fa-solid fa-user"></i>
      </button>
    </form>
  </div>
</nav>
<div id="modal-search" class="modal">
  <div class="modal__overlay" style="margin-top: var(--nav-height); position:fixed;" onclick="closeModalSearch()">
  </div>
  <div class="modal__body ">
    <div class="modal__inner">
      <div class="search-container">
        <form method="get" action="get-prods-by-model" class="input-txt__group">
          <input id="input-element-nav" name="model" class="input-search" type="search">
          <i id="clear-btn-search-nav" class="fa-solid fa-circle-xmark close-btn"></i>
          <button type="submit" class="find-btn" style="border: none; background-color: transparent">
            <i class="fa-regular fa-magnifying-glass "></i>
          </button>
        </form>
        <div class="search__fast">
          <p>Quick Links</p>
          <div class="list__search-link">
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
            </div>
          </div>
        </div>
        <div class="search_history">
          <p>Search history</p>
          <div class="list__search-link">
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <i class="fa-solid fa-magnifying-glass hover_icon" ></i>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="<c:url value="/static/js/navbar.js"/>" async defer ></script>
</body>
</html>
