<%--
  Created by IntelliJ IDEA.
  User: TRUONG AN
  Date: 10/27/2023
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
  <link rel="stylesheet" href="./static/css/search.css">
  <link rel="stylesheet" href="./static/css/navbar.css">
</head>
<body>
<nav class="navbar-main">
  <img class="navbar-logo" src="./static/images/logo.svg" alt="logo">
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
        <b class="btn-txt">Mobile</b>
      </div>
    </li>
    <li class="navbar-item">
      <div class="button-inner btn-obj">
        <b class="btn-txt">Accessory</b>
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
      <img id="nav-list-btn"  src="./static/images/list-btn.svg" >
      <ul id="nav-menu" class="navbar-menu">
        <li class="navbar__menu-item">
          <p>Sales</p>
        </li>
        <li class="navbar__menu-item">
          <p>Laptop</p>
        </li>
        <li class="navbar__menu-item">
          <p>Mobile</p>
        </li>
        <li class="navbar__menu-item">
          <p>Accessory</p>
        </li>
        <li class="navbar__menu-item">
          <p>Support</p>
        </li>
      </ul>
    </div>
    <img class="nav__btn-icon icon-obj" src="./static/images/btnsearch.svg" onclick="openModalSearch()">
    <img class="nav__btn-icon icon-obj" src="./static/images/cart.svg" alt="cart">
    <img class="nav__btn-icon icon-obj" src="./static/images/account.svg" alt="">
  </div>

</nav>
<div id="modal-search" class="modal">
  <div class="modal__overlay" style="margin-top: var(--nav-height); position:fixed;" onclick="closeModalSearch()">
  </div>
  <div class="modal__body ">
    <div class="modal__inner">
      <div class="search-container">
<%--        <form method="get" class="search__box">--%>
<%--          <input id="inputSearch" name="model" type="search" >--%>
<%--          <img class="icon-obj" src="./static/images/btnsearch.svg" alt="">--%>
<%--        </form>--%>
        <form method="get" action="get-prods-by-model" class="input-txt__group">
          <input id="input-element" name="model" class="input-search" type="search">
          <i id="clear-btn-search" class="fa-solid fa-circle-xmark close-btn"></i>
          <button type="submit" class="find-btn" style="border: none; background-color: transparent">
            <i class="fa-regular fa-magnifying-glass "></i>
          </button>
        </form>
        <div class="search__fast">
          <p>Quick Links</p>
          <div class="list__search-link">
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="./static/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="./static/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="./static/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="./static/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="./static/images/btnsearch.svg" alt="">
            </div>
          </div>
        </div>
        <div class="search_history">
          <p>Search history</p>
          <div class="list__search-link">
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="./static/images/btnsearch.svg" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="./static/js/navbar.js"></script>
</body>
</html>
