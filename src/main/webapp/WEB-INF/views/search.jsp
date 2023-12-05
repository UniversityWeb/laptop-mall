
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/search.css"/>" type="text/css">
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>
<section class="query-input__wrap">
    <form method="get" action="get-prods-by-model" class="input-txt__group">
        <input id="input-element" name="model" class="input-search" type="search">
        <i id="clear-btn-search" class="fa-solid fa-circle-xmark close-btn"></i>
        <button type="submit" class="find-btn" style="border: none; background-color: transparent">
            <i class="fa-regular fa-magnifying-glass "></i>
        </button>
    </form>

    <ul class="search__recomments">
        <li class="search__recomments-item">
            <a href="<%= contextPath %>/get-prods-by-model?model=FHD">
                <span>FHD</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </a>
        </li>
        <li class="search__recomments-item">
            <a href="<%= contextPath %>/get-prods-by-model?model=Gaming">
                <span>Gaming</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </a>

        </li>
        <li class="search__recomments-item">
            <a href="<%= contextPath %>/get-prods-by-model?model=Dell">
                <span>Dell</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </a>
        </li>
        <li class="search__recomments-item">
            <a href="<%= contextPath %>/get-prods-by-model?model=Laptop">
                <span>Laptop</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </a>
        </li>
        <li class="search__recomments-item">
            <a href="<%= contextPath %>/get-prods-by-model?model=Keyboard">
                <span>Keyboard</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </a>
        </li>
        <li class="search__recomments-item">
            <a href="<%= contextPath %>/get-prods-by-model?model=Monitor">
                <span>Monitor</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </a>
        </li>
    </ul>
</section>
<section class="result-search__container">
    <section class="tab-bar">
        <ul class="tab-bar__list">
            <li class="tab-bar__item">
                <span>All</span>
                <span class="number-results">(${prods.size()})</span>
            </li>
        </ul>
    </section>
    <section class="features-search">
        <ul class="filter-selects">
            <li class="filter-select__title">
                <p>FILTER</p>
            </li>
            <li class="filter-select__clear">
                <i id="reset-icon" class="fa-solid fa-arrows-rotate "> </i>
            </li>
        </ul>
        <ul class="sort-selects">
            <li class="sort-select__title">
                <p>SORT BY</p>
            </li>
            <li id="sort-btn" class="sort-select__arrow">
                <i  class="fa-solid fa-chevron-down select-sort__btn"></i>
                <div id="sort-container" class="sort-container">
                    <input type="button" id="sortLtoH" value="Price Low to High">
                    <input type="button" id="sortHtoL" value="Price High to Low">
                    <input type="button" id="sortAtoZ" value="A-Z">
                    <input type="button" id="sortZtoA" value="Z-A">
                </div>
            </li>
        </ul>
    </section>
    <section class="result-content">
        <div class="filter-select__content">
            <span class="filter-title">Price</span>
            <div class="filter-price-prods">
                <div class="radio_group">
                    <input type="radio"  name="priceFilter" id="radio-price0" value="all"  onclick="filterProducts()">
                    <label class="form-check-label" for="radio-price0">
                        All
                    </label>
                </div>
                <div class="radio_group">
                    <input type="radio" name="priceFilter" id="radio-price1" value="250000"  onclick="filterProducts()">
                    <label class="form-check-label" for="radio-price1">
                        250.000 and below
                    </label>
                </div>
                <div class="radio_group">
                    <input type="radio" name="priceFilter" id="radio-price2" value="500000"  onclick="filterProducts()">
                    <label class="form-check-label" for="radio-price2">
                        500.000 and below
                    </label>
                </div>
                <div class="radio_group">
                    <input type="radio" name="priceFilter" id="radio-price3" value="1000000"  onclick="filterProducts()">
                    <label class="form-check-label" for="radio-price3">
                        1.000.000 and below
                    </label>
                </div>
            </div>
            <span class="filter-title">Category</span>
            <select id="categorySelect" class="form-select filter-select-prods" aria-label="Default select example">
                <option selected>All</option>
                <option>Laptop</option>
                <option>Keyboard</option>
                <option>Monitor</option>
            </select>
            <span class="filter-title">Branch</span>
            <select id="brandSelect" class="form-select filter-select-prods" aria-label="Default select example">
                <option selected >All</option>
            </select>
        </div>
        <ul  class="search-item__list " id="productList">
            <c:forEach var="product" items="${prods}">
                <li class="search__product-result">
                    <div class="product__img">
                        <img src="<c:url value="${product.imageUrls[0]}"/>" alt="">
                    </div>
                    <div class="product_info">
                        <span class="product__name"><c:out value="${product.model}" /></span>
                        <span class="product__id"><c:out value="${product.id}" /></span>
                        <span class="product__price"><c:out value="${product.price}" /></span>
                        <input type="hidden" class="product__brand" value="${product.brand}">
                        <input type="hidden" class="product__category" value="${product.category}">
                        <div class="product_des">
                            <span>Color:  <c:out value="${product.color}"/></span>
                        </div>
                        <div class="product__selection">
                            <form  action="add-cart-item" method="post" style="width: 50%;">
                                <button type="submit" class="button__add-cart" style="width: 80%;">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </button>
                            </form>

                            <a href="get-prod-by-id?id=${product.id}" class="input__group-selection">
                                <input type="submit" value="LEARN MORE">
                                <div class="line"></div>
                            </a>
                            <div class="input__group-selection">
                                <input type="button" value="FIND SUPPORT" onclick="openChatbox()">
                                <div class="line"></div>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </section>
</section>
<footer></footer>
<jsp:include page="customer-chatbox.jsp"></jsp:include>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
<script src="<c:url value="/static/js/search.js"/>" async defer ></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>

</html>