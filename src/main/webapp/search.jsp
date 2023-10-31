<%--
  Created by IntelliJ IDEA.
  User: TRUONG AN
  Date: 10/31/2023
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="asset/styles/base.css" />
    <link rel="stylesheet" href="asset/styles/search.css" />
    <link rel="stylesheet" href="asset/fonts/fontawesome-free-6.4.2-web/fontawesome-free-6.4.2-web/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<section class="query-input__wrap">
    <input class="input-search" type="text">
    <ul class="search__recomments">
        <li class="search__recomments-item">
            <p>ABHxbsddddddddddhcshcb</p>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <p>ABHxbshcshcbffrfrg</p>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <p>ABHxbshcshcb</p>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <p>ABHxbscdvdfvvvvvvvvvvvvvvvhcb</p>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <p>ABHxbshffbfbcshcb</p>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <p>ABHxbshcshcb</p>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
    </ul>
</section>
<section class="result-search__container">
    <section class="tab-bar">

        <ul class="tab-bar__list">
            <li class="tab-bar__item">
                <p>All</p>
            </li>
            <li class="tab-bar__item">
                <p>Product</p>
            </li>
            <li class="tab-bar__item">
                <p>Accessory</p>
            </li>
        </ul>
    </section>

    <section class="features-search">
        <ul class="filter-selects">
            <li class="filter-select__title">
                <p>FILTER</p>
            </li>
            <li class="filter-select__clear">
                <i class="fa-solid fa-trash"></i>
            </li>
        </ul>
        <ul class="sort-selects">
            <li class="sort-select__title">
                <p>SORT BY</p>
            </li>
            <li class="sort-select__arrow">
                <i class="fa-solid fa-chevron-down"></i>
            </li>
        </ul>
    </section>
    <section class="result-content">
        <div class="filter-select__content">

        </div>
        <ul class="search-item__list">
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
            <li class="search__product-result">
                <img src="asset/images/headphone-white.png" alt="" class="product__img">
                <p class="product__name">Khoa đần</p>
                <img src="asset/images/btnbuynow.svg" alt="" class="btn__add-to-cart">
            </li>
        </ul>
    </section>
</section>
<footer></footer>
<jsp:include page="chatbox.jsp"></jsp:include>
<script src="./asset/javascript/search.js"></script>
</body>
</html>
