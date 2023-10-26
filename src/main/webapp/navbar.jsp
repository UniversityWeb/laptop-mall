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
  <link rel="stylesheet" href="asset/styles/base.css" />
  <link rel="stylesheet" href="asset/styles/navbar.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@700&display=swap"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"/>
</head>
<body>
<nav class="navbar-main">
  <img class="navbar-logo" src="asset/images/logo.svg" alt="logo">
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
      <img id="nav-list-btn"  src="asset/images/list-btn.svg" >
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
    <img class="nav__btn-icon icon-obj" src="asset/images/btnsearch.svg" onclick="openModalSearch()">
    <img class="nav__btn-icon icon-obj" src="asset/images/cart.svg" alt="cart">
    <img class="nav__btn-icon icon-obj" src="asset/images/account.svg" alt="">
  </div>

</nav>
<div id="modal-search" class="modal">
  <div class="modal__overlay" style="margin-top: var(--nav-height); position:fixed;" onclick="closeModalSearch()">
  </div>
  <div class="modal__body ">
    <div class="modal__inner">
      <div class="search-container">
        <div class="search__box">
          <input id="inputSearch" type="text" >
          <img class="icon-obj" src="asset/images/btnsearch.svg" alt="">
        </div>
        <div class="search__fast">
          <p>Quick Links</p>
          <div class="list__search-link">
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="asset/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="asset/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="asset/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="asset/images/btnsearch.svg" alt="">
            </div>
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="asset/images/btnsearch.svg" alt="">
            </div>
          </div>
        </div>
        <div class="search_history">
          <p>Search history</p>
          <div class="list__search-link">
            <div class="search__link-item">
              <p>Abcjjkcjscncsjcsjcc</p>
              <img src="asset/images/btnsearch.svg" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>
<script src="asset/javascript/navbar.js"></script>
</body>
</html>
