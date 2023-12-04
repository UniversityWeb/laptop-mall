<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/seller-main-page.css"/>" type="text/css">
</head>
<body>
<jsp:include page="seller-navbar.jsp"></jsp:include>

<section class="prod-management__container">
    <div class="tab-bar">
        <form method="get" action="get-prods-by-model" class="input-txt__group">
            <input id="input-element-prod" name="model" class="input-search" type="search">
            <i id="clear-btn-search-prod" class="fa-solid fa-circle-xmark close-btn"></i>
            <button type="submit" class="find-btn" style="border: none; background-color: transparent">
                <i class="fa-regular fa-magnifying-glass "></i>
            </button>
        </form>
        <form class="tab-bar__item" action="products-management" method="post">
            <input class="tab-bar__item-input" type="submit" name="action" value="All">
            <input class="tab-bar__item-input" type="submit" name="action" value="Filter">
            <input class="tab-bar__item-input" type="submit" name="action" value="New">
        </form>
    </div>
    <section class="product-container">
        <ul class="product-list">

            <c:forEach var="product" items="${products}">
                <li class="product-item">
                    <div class="img-boder">
                        <img src="app/prod/${product.id}-0.png" alt="">
                    </div>
                    <label>${product.name}</label>
                    <div class="product-bottom">
                        <a href="products-management?action=see-more&amp;prodID=${product.id}">
                            <i class="fa-solid fa-eye"></i>
                        </a>
                        <i class="fa-solid fa-pen"></i>
                        <i class="fa-solid fa-trash"></i>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </section>
</section>

<section class="product-info" style="display: ${displayProductInfo}">
    <form action="products-management" method="post" class="product-info__tabbar">
        <input type="hidden"  name="action" value="close">
        <input type="submit" class="product-info__close" value="close">
    </form>
    <div class="product-info__container">
        <form  action="products-management" method="post" enctype="multipart/form-data" class="product-info__form">
            <div class="form-input__group">
                <label>ID:</label>
                <input name="prodID" class="form-input__item" type="text" value="${productIns.id}">
            </div>
            <div class="form-input__group">
                <label>Name:</label>
                <input name="prodName" class="form-input__item" type="text" value="${productIns.name}">
            </div>
            <div class="form-input__group">
                <label>Price:</label>
                <input name="prodPrice" class="form-input__item" type="text" value="${productIns.price}">
            </div>
            <input id="imgInput" class="select-file__input" name="images" type="file" multiple accept="image/*">
            <input class="btn-save" type="submit" name="action" value="Save">
        </form>
        <div class="product-info__listimg">

            <ul id="imgList" class="img-list">
                <c:forEach var="imgName" items="${imgList}">
                    <li class="img-item">
                        <div class="img-bottom"><i class="fa-solid fa-trash"></i></div>
                        <img src="app/prod/${imgName}" alt="">
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

</section>
<footer>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
<script src="<c:url value="/static/js/seller-main-page.js"/>" async defer ></script>
</body>
</html>
