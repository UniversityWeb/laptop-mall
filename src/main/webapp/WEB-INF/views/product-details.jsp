<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>${prod.model}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="<c:url value="/static/css/product-details.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>">
</head>
<body>
<input type="checkbox" id="check">
<jsp:include page="navbar.jsp"></jsp:include>
<nav>
    <div class="navigation">
        <a href="#prod-features">Features</a>
        <a href="#prod-specifications">Specifications</a>
        <a href="#prod-comparisons">Comparisons</a>
    </div>
    <label class="btn_collapse" for="check">
        <i class="fas fa-bars menu-btn"></i>
        <i class="fas fa-times close-btn"></i>
    </label>
</nav>
<section class="product-detail__container">
    <section id="prod-features">
        <div class="container">
            <section class="prod_img-content">
                <ul class="prod_img-list">

                    <c:url value=""/>
                    <li class="prod_img-item">
                        <img src="<c:url value="/static/images/headphone-white.png"/>" alt="item">
                    </li>

                    <li class="prod_img-item">
                        <img src="<c:url value="/static/images/headphone-white.png"/>" alt="item">
                    </li>
                    <li class="prod_img-item">
                        <img src="<c:url value="/static/images/headphone-white.png"/>" alt="item">
                    </li>
                    <li class="prod_img-item">
                        <img src="<c:url value="/static/images/headphone-white.png"/>" alt="item">
                    </li>
                </ul>
                <div  class="prod_img-full">
                    <img id="prod_img-full" src="" alt="item-selected">
                    <div class="back-next_selector">
                        <i id="backImgProd" class="fa-solid fa-angle-left"></i>
                        <i id="nextImgProd" class="fa-solid fa-angle-right"></i>
                    </div>
                </div>

            </section>
            <section id="prod-specifications">
                <div class="prod-specifications-header">
                    <h3>Configuration characteristics</h3>
                    <div class="view-details">
                        <span>View detailed configuration</span>
                        <i class="fa-solid fa-angles-right"></i>
                    </div>
                </div>
                <div class="prod-specifications__container">
                    <div class="prod-specification__content">
                            <span class="title-prod-confi">
                                Processor
                            </span>
                        <div class="confi-details">
                            <div class="confi-item">
                                <span class="item-name">CPU Type:</span>
                                <span class="item-values"> Intel Core i5-1335U, 10C/12T</span>
                            </div>
                            <div class="confi-item">
                                <span class="item-name">Speed:</span>
                                <span class="item-values">1.0GHz , Up to 4.6GHz</span>
                            </div>
                            <div class="confi-item">
                                <span class="item-name">Cache:</span>
                                <span class="item-values">12MB</span>
                            </div>
                        </div>
                    </div>
                    <div class="prod-specification__content">
                            <span class="title-prod-confi">
                                Processor
                            </span>
                        <div class="confi-details">
                            <div class="confi-item">
                                <p class="item-name">CPU Type:</p>
                                <p class="item-values"> Intel Core i5-1335U, 10C/12T</p>
                            </div>
                            <div class="confi-item">
                                <p class="item-name">Speed:</p>
                                <p class="item-values">1.0GHz , Up to 4.6GHz</p>
                            </div>
                            <div class="confi-item">
                                <p class="item-name">Cache:</p>
                                <p class="item-values">12MB</p>
                            </div>
                        </div>
                    </div>
                    <div class="prod-specification__content">
                            <span class="title-prod-confi">
                                Processor
                            </span>
                        <div class="confi-details">
                            <div class="confi-item">
                                <span class="item-name">CPU Type:</span>
                                <span class="item-values"> Intel Core i5-1335U, 10C/12T</span>
                            </div>
                            <div class="confi-item">
                                <span class="item-name">Speed:</span>
                                <span class="item-values">1.0GHz , Up to 4.6GHz</span>
                            </div>
                            <div class="confi-item">
                                <span class="item-name">Cache:</span>
                                <span class="item-values">12MB</span>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <div class="prod_basic_info">
            <div class="brand-name">
                DELL INSPIRON HIỆU SUẤT CAO</div>
            <div class="group-basic-info">
                <div class="prod__id-content">
                    <input type="text" name="" id="prod-id" value="Inspirion14543002NS">
                    <button onclick="copyToClipboard()"><i class="fa-solid fa-copy"></i></button>
                </div>
                <span class="prod-name">
                        Dell Inspiron 14 5430 - i5 1340P, 16GB, 512GB, FHD+ - Platinum Silver - New, Sealed, Imported
                    </span>
                <div class="product-attributes">
                        <span class="product-attributes__name">
                            Version
                        </span>
                    <ul class="product-attribute__values">
                        <li class="prod-value__item">
                            abc s1323
                        </li>
                        <li class="prod-value__item">
                            xzza 243
                        </li>
                        <li class="prod-value__item">
                            dvd 322
                        </li>
                    </ul>
                </div>
                <div class="product-attributes">
                        <span class="product-attributes__name">
                            color
                        </span>
                    <ul class="product-attribute__values">
                        <li class="prod-value__item">
                            Platinum Silver
                        </li>
                        <li class="prod-value__item">
                            Black
                        </li>
                        <li class="prod-value__item">
                            Gray
                        </li>
                    </ul>
                </div>
                <div class="product-attributes">
                        <span class="product-attributes__name">
                            Type of goods
                        </span>
                    <ul class="product-attribute__values">
                        <li class="prod-value__item">
                            vvfvfdbfbgb
                        </li>
                        <li class="prod-value__item">
                            vvfvfdbfbgb
                        </li>
                        <li class="prod-value__item">
                            vvfvfdbfbgb
                        </li>
                    </ul>
                </div>
                <div class="amount-prod">
                    <span class="amount-title">Amount</span>
                    <div class="amount-content">
                        <button id="subBtn" class="sub-btn">
                            <i class="fa-solid fa-minus"></i>
                        </button>
                        <input type="text" name="" id="inputMount" class="amount-value" value="0">
                        <button id="plusBtn" class="plus-btn">
                            <i class="fa-solid fa-plus"></i>
                        </button>
                    </div>
                </div>
                <div class="line"></div>
                <div class="group-selections__prod">
                    <div class="prod-price">
                        <div class="prod-total__price">
                            120.999$
                        </div>
                        <div class="prod-extra__price">
                            <div class="old-price">138.999$</div>
                            <div class="discount-price">-29%</div>
                        </div>
                    </div>
                    <div class="selections-content">
                        <button class="button__add-cart">
                            <i class="fa-solid fa-cart-shopping button__icon"></i>
                            <span>Add to cart</span>
                        </button>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </section>

    <section id="prod-comparisons">
        <p style="height: 500px">

        </p>
    </section>
</section>
<footer>

</footer>

<script src="<c:url value="/static/js/product-details.js"/>"></script>

</body>
</html>