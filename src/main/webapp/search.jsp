<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="<c:url value="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/>">
    <link rel="stylesheet" href="<c:url value="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css"/>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <link rel="stylesheet" href="<c:url value="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>">
    <link rel="stylesheet" href="<c:url value="static/css/search.css"/>">
    <link rel="stylesheet" href="<c:url value="static/css/base.css"/>">
</head>

<body>
<jsp:include page="WEB-INF/views/navbar.jsp"></jsp:include>
<section class="query-input__wrap">
    <div class="input-txt__group">
        <input id="input-element" class="input-search" type="text">

        <i id="clear-btn-search" class="fa-solid fa-circle-xmark close-btn"></i>

        <i class="fa-regular fa-magnifying-glass find-btn"></i>
    </div>

    <ul class="search__recomments">
        <li class="search__recomments-item">
                <span>ABHxbsddddddddddhcshcb</span>
                <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <span>ABHxbshcshcbffrfrg</span>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <span>ABHxbshcshcb</span>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <span>ABHxbscdvdfvvvvvvvvvvvvvvvhcb</span>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <span>ABHxbshffbfbcshcb</span>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
        <li class="search__recomments-item">
            <span>ABHxbshcshcb</span>
            <i class="fa-solid fa-magnifying-glass"></i>
        </li>
    </ul>
</section>
<section class="result-search__container">
    <section class="tab-bar">
        <ul class="tab-bar__list">
            <li class="tab-bar__item">
                <span>All</span>
                <span class="number-results">(26)</span>
            </li>
        </ul>
    </section>

    <section class="features-search">
        <ul class="filter-selects">
            <li class="filter-select__title">
                <p>FILTER</p>
            </li>
            <li class="filter-select__clear">
                <i id="reset-icon" class="fa-solid fa-arrows-rotate "></i>
            </li>
        </ul>
        <ul class="sort-selects">
            <li class="sort-select__title">
                <p>SORT BY</p>
            </li>
            <li id="sort-btn" class="sort-select__arrow">
                <i  class="fa-solid fa-chevron-down select-sort__btn"></i>
                <div id="sort-container" class="sort-container">
                    <input type="submit" value="Lastest">
                    <input type="submit" value="Oldest">
                    <input type="submit" value="A-Z">
                    <input type="submit" value="Z-A">
                </div>
            </li>
        </ul>
    </section>
    <section class="result-content">
        <div class="filter-select__content">
            <div class="radio_group">
                <input type="radio" name="price-radio" id="radio-price1">
                <label class="form-check-label" for="radio-price1">
                    <= 100
                </label>
            </div>
            <div class="radio_group">
                <input type="radio" name="price-radio" id="radio-price2">
                <label class="form-check-label" for="radio-price2">
                    > 100 <= 500
                </label>
            </div>

            <div class="radio_group">
                <input type="radio" name="price-radio" id="radio-price3">
                <label class="form-check-label" for="radio-price3">
                    > 500
                </label>
            </div>

            <!-- <input type="submit" value="<=100">
            <input type="submit" value=">100 and <=500">
            <input type="submit" value=">500"> -->
        </div>
        <ul class="swiper mySwiper search-item__list ">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                </div>
                <div class="swiper-slide">
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                    <li class="search__product-result">
                        <div class="product__img">
                            <img src="static/images/headphone-white.png" alt="">
                        </div>
                        <div class="product_info">
                            <span class="product__name">HeadPhone ABCDEFGHIJKJHHGBJBSBJS</span>
                            <span class="product__id">PROD-001-01</span>
                            <span class="product__price">18.99$</span>
                            <div class="product_des">
                                <span>-- Miễn phí 6 tháng Samsung Care+ và gói dịch vụ cao cấp</span>
                                <span>-- Nhập HELLONOV ưu đãi ngay 1 triệu</span>
                            </div>
                            <div class="product__selection">
                                <div class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="LEARN MORE">
                                    <div class="line"></div>
                                </div>
                                <div class="input__group-selection">
                                    <input type="submit" value="FIND SUPPORT">
                                    <div class="line"></div>
                                </div>
                            </div>

                        </div>

                    </li>
                </div>
            </div>
            <div class="swiper-pagination"></div>
        </ul>
    </section>
</section>

<footer></footer>
<jsp:include page="WEB-INF/views/chatbox.jsp"></jsp:include>
<script src="<c:url value="static/js/search.js"/>" async defer></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"/>" async defer></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
</body>

</html>