<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/home.css"/>" type="text/css">
</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>
<section class="pr-container">
<%--    <canvas id="canvas3d_text" class="pr-video"></canvas>--%>
    <img class="pr-video" alt="video" src="./static/images/prvideo.gif" />
</section>
<section class="laptop-container">
    <section class="laptop-title">
<%--        <canvas id="canvas3d_laptop"></canvas>--%>
        <span class="txt-laptop">Laptop</span>
    </section>
    <section  class="laptop-content">
<%--        <section class="laptop-mall">--%>
<%--            <img class="laptop-fish" src="<c:url value="/static/images/laptopfish.gif"/>" alt="laptop-fish">--%>
<%--            <img class="laptopmall-frame" src="<c:url value="/static/images/laptopmall-frame.png"/>" alt="laptopmall-frame">--%>
<%--        </section>--%>
        <section class="laptop__list-gif">
            <img  src="<c:url value="/static/images/giphy1.gif"/>" alt="giphy">
            <img src="<c:url value="/static/images/giphy8.gif"/>" alt="giphy">
            <img src="<c:url value="/static/images/giphy2.gif"/>" alt="giphy">
            <img src="<c:url value="/static/images/giphy11.gif"/>" alt="giphy">
        </section>
        <section class="laptop__list-logo">
            <img src="<c:url value="/static/images/logo-mac.png"/>" alt="mac-logo">
            <img src="<c:url value="/static/images/logo-asus.png"/>" alt="asus-logo">
            <img src="<c:url value="/static/images/logo-hp.png"/>" alt="hp-logo">
            <img src="<c:url value="/static/images/logo-msi.png"/>" alt="msi-logo">
            <img src="<c:url value="/static/images/logo-acer.png"/>" alt="acer-logo">
            <img src="<c:url value="/static/images/logo-dell.png"/>" alt="dell-logo">
        </section>
        <section style="display: flex;justify-content: center;align-items: center">
            <form method="get" action="get-prods-by-category" class="more-product">
                <input type="hidden" name="category" value="laptop">
                <input type="submit" value="LEARN MORE">
                <div class="line"></div>
            </form>
        </section>
        <section>
            <div class="product-container swiper product-Swiper">
                <div class=" swiper-wrapper product-wrapper">
                    <c:forEach var="product" items="${laptops}">
                        <div class="swiper-slide">
                            <form  action="add-cart-item" method="post" class="product-item">
                                <img class="product-img" alt="" src="<c:url value="/static/images/laptop-product.png"/>" />
                                <b class="product-name" name="model"><c:out value="${product.model}" /></b>
                                <input type="hidden" name="productId" value="${product.id}">
                                <button type="submit" class="button__add-cart">
                                    <i class="fa-solid fa-cart-shopping button__icon"></i>
                                    <span>Add to cart</span>
                                </button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
                <img class="icon-obj swiper-button-prev" alt="" src="<c:url value="/static/images/btnback.svg"/>" />
                <img class="icon-obj swiper-button-next"  alt="" src="<c:url value="/static/images/btnnext.svg"/>" />
                <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
            </div>
        </section>
    </section>
</section>
<section class="accessory-container">
    <section class="accessory-title">
        <img class="laptop-girl" src="<c:url value="/static/images/girl-headphone.png"/>" alt="">
        <b class="accessory-txt">Accessory</b>
        <img class="giphy-9" src="<c:url value="/static/images/giphy9.gif"/>" alt="">
    </section>
    <section class="accessory__product-container">
        <section class="accessory__group-img">
            <img class="accessory__product-img" src="<c:url value="/static/images/keyboard-white.png"/>"alt="" style="margin-left: 1%; margin-bottom:-5%;">
            <img src="<c:url value="/static/images/block1.png"/>" alt="">
            <form method="get" action="get-prods-by-category" class="more-product">
                <input type="hidden" name="category" value="keyboard">
                <input type="submit" value="LEARN MORE">
                <div class="line"></div>
            </form>
        </section>
        <section class="accessory__list-item swiper product-Swiper">
            <div class=" swiper-wrapper product-wrapper">
                <c:forEach var="product" items="${keyboards}">
                    <div class="swiper-slide">
                        <form  action="add-cart-item" method="post" class="product-item">
                            <img class="product-img" alt="" src="<c:url value="/static/images/keyboard.png"/>" />
                            <b class="product-name" name="model"><c:out value="${product.model}" /></b>
                            <input type="hidden" name="productId" value="${product.id}">
                            <button type="submit" class="button__add-cart">
                                <i class="fa-solid fa-cart-shopping button__icon"></i>
                                <span>Add to cart</span>
                            </button>
                        </form>
                    </div>
                </c:forEach>
            </div>
            <img class="icon-obj swiper-button-prev" alt="" src="<c:url value="/static/images/btnback.svg"/>" />
            <img class="icon-obj swiper-button-next"  alt="" src="<c:url value="/static/images/btnnext.svg"/>" />
            <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
        </section>
    </section>
    <section class="accessory__product-container">
        <section class="accessory__group-img">
            <img class="accessory__product-img" src="<c:url value="/static/images/monitor.svg"/>"alt="monitor" style="margin-left: 1%; margin-bottom:-7%;">
            <img src="<c:url value="/static/images/block1.png"/>" alt="">
            <form method="get" action="get-prods-by-category" class="more-product">
                <input type="hidden" name="category" value="monitor">
                <input type="submit" value="LEARN MORE">
                <div class="line"></div>
            </form>
        </section>
        <section class="accessory__list-item swiper product-Swiper">
            <div class=" swiper-wrapper product-wrapper">
                <c:forEach var="product" items="${monitors}">
                    <div class="swiper-slide">
                        <form  action="add-cart-item" method="post" class="product-item">
                            <img class="product-img" alt="" src="<c:url value="/static/images/monitor.svg"/>" />
                            <b class="product-name" name="model"><c:out value="${product.model}" /></b>
                            <input type="hidden" name="productId" value="${product.id}">
                            <button type="submit" class="button__add-cart">
                                <i class="fa-solid fa-cart-shopping button__icon"></i>
                                <span>Add to cart</span>
                            </button>
                        </form>
                    </div>
                </c:forEach>
            </div>
            <img class="icon-obj swiper-button-prev" alt="" src="<c:url value="/static/images/btnback.svg"/>" />
            <img class="icon-obj swiper-button-next"  alt="" src="<c:url value="/static/images/btnnext.svg"/>" />
            <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
        </section>
    </section>
</section>
<footer>
</footer>
<jsp:include page="chatbox.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
<script src="<c:url value="/static/js/home.js"/>" async defer ></script>
<%--<script async src="https://unpkg.com/es-module-shims@1.3.6/dist/es-module-shims.js"></script>--%>
<%--<script type="importmap">--%>
<%--      {--%>
<%--        "imports": {--%>
<%--          "@splinetool/runtime": "https://unpkg.com/@splinetool/runtime@0.9.516/build/runtime.js"--%>
<%--        }--%>
<%--      }--%>
<%--  </script>--%>
<%--<script type="module" src="<c:url value="/static/js/pline.js"/>" async defer ></script>--%>
</body>
</html>