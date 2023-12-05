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
        <form method="post" action="seller-main-page" class="input-txt__group">
            <input type="hidden" name="action" value="Search">
            <input id="input-element-prod" name="model" class="input-search" type="search">
            <i id="clear-btn-search-prod" class="fa-solid fa-circle-xmark close-btn"></i>
            <button type="submit" class="find-btn" style="border: none; background-color: transparent">
                <i class="fa-regular fa-magnifying-glass "></i>
            </button>
        </form>
        <form class="tab-bar__item" action="seller-main-page" method="post">
            <input class="tab-bar__item-input" type="submit" name="action" value="All">
            <input class="tab-bar__item-input" id="filter-btn" type="button" value="Filter">
            <input class="tab-bar__item-input" id="sort-btn" type="button" value="Sort">
            <input class="tab-bar__item-input" id="statistics-btn" type="button" value="Statistics">
            <input class="tab-bar__item-input" type="submit" name="action" value="New">
        </form>
        <div id="filter-container" class="sort-container">
            <input type="button" id="filterLaptop" value="Laptop">
            <input type="button" id="filterKeyboard" value="Keyboard">
            <input type="button" id="filterMonitor" value="Monitor">
        </div>
        <div id="sort-container" class="sort-container">
            <input type="button" id="sortLtoH" value="Price Low to High">
            <input type="button" id="sortHtoL" value="Price High to Low">
            <input type="button" id="sortAtoZ" value="A-Z">
            <input type="button" id="sortZtoA" value="Z-A">
        </div>
    </div>
    <section class="product-container">
        <ul class="product-list">
            <c:forEach var="product" items="${prods}">
                <li class="product-item">
                    <div class="img-boder">
                        <img src="app/prod/${product.id}-0.png" alt="zz">

                    </div>
                    <label><c:out value="${product.model}" /></label>
                    <form action="seller-main-page" method="post" class="product-bottom">
                        <a href="get-prod-by-id?id=${product.id}">
                            <i class="fa-solid fa-eye"></i>
                        </a>
                        <input type="hidden" style="width: 0;height: 0;" name="prodID" value="${product.id}">
                        <button type="submit" name="action" value="Update" style="background: none;border: none; margin: 0;padding: 0;">
                            <i class="fa-solid fa-pen"></i>
                        </button>
                        <i class="fa-solid fa-trash" onclick="openConfirmModal(${product.id})"></i>
                    </form>
                </li>
            </c:forEach>
        </ul>
    </section>
</section>


    <div id="modal-confirm" class="modal">
        <div class="modal__overlay" style="margin-top: var(--nav-height); position:fixed;" onclick="closeModalSearch()">
        </div>
        <div class="modal__body">
            <div class="modal__inner">
                <form class="confirm-container">
                    <div class="form-header">
                        <div class="title">
                            <span onclick="closeModalConfirm()">Confirmation Message ! </span>
                            <i class="fa-light fa-message-smile" onclick="closeModalConfirm()"></i>
                        </div>
                        <i class="fa-solid fa-chevron-down" onclick="closeModalConfirm()"></i>
                    </div>
                    <form action="delete-prod" method="post" class="form-content">
                        <span id="confirmMess" class="confirm-mess">None</span>
                        <input id="confirmProdID" type="hidden" name="prodID" value="">
                        <input id="confirmAction" type="hidden" name="action" value="delete">
                        <div class="form-selection">
                            <input class="confirm-btn" id="yesBtn" type="submit" value="Yes" onclick="closeModalConfirm()">
                            <input class="confirm-btn" id="noBtn" type="button" value="No" onclick="closeModalConfirm()">
                        </div>
                    </form>
                </form>
            </div>
        </div>
    </div>
<footer>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
<script src="<c:url value="/static/js/seller-main-page.js"/>" async defer ></script>
</body>
</html>
