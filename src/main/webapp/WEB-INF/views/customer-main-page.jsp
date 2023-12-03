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
    <img class="pr-video" alt="video" src="./static/images/prvideo.gif" />
</section>
<section class="smartphone-container">
    <section class="smartphone-title">
        <img class="phone-magic" alt="" src="./static/images/phone-magic.png" />
        <b class="txt__smart-phone">Mobile</b>
        <img class="giphy-4" alt="" src="./static/images/giphy4.gif" />
    </section>
    <section  class="smartphone-content">
        <div class="smartphone-btn-menu">
            <div class="phone__btnmenu-item btn-obj">
                <b class="smartphone__btn-txt">All</b>
            </div>
            <div class="phone__btnmenu-item btn-obj">
                <b class="smartphone__btn-txt">Samsung</b>
            </div>
            <div class="phone__btnmenu-item btn-obj">
                <b class="smartphone__btn-txt">Iphone</b>
            </div>
        </div>
        <div class="product-container swiper product-Swiper">
            <div class=" swiper-wrapper product-wrapper">
                <c:forEach var="product" items="${laptops}">
                    <div class="swiper-slide">
                        <form class="product-item" action="add-cart-item" method="post">
                            <input type="hidden" name="productId" value="${product.id}">
                            <img class="product-img" alt="" src="<c:url value="/static/images/smartphone-product.png"/>" />
                            <b class="product-name"><c:out value="${product.model}" /></b>
                            <button type="submit" class="button__add-cart">
                                <i class="fa-solid fa-cart-shopping button__icon"></i>
                                <span>Add to cart</span>
                            </button>
                        </form>
                    </div>
                </c:forEach>

            </div>
            <img class="icon-obj swiper-button-prev" alt="" src="./static/images/btnback.svg" />
            <img class="icon-obj swiper-button-next"  alt="" src="./static/images/btnnext.svg" />
            <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
        </div>

    </section>
</section>
<section class="laptop-container">
    <section class="laptop-title">
        <img class="girl-laptop" alt="" src="./static/images/girl-laptop.png" />
        <b class="txt-laptop">Laptop</b>
        <img class="boy-laptop" alt="" src="./static/images/boy-laptop.png" />
    </section>
    <section  class="laptop-content">

        <section class="laptop-mall">
            <img class="laptop-fish" src="./static/images/laptopfish.gif" alt="">
            <img class="laptopmall-frame" src="./static/images/laptopmall-frame.png" alt="">
        </section>
        <section class="laptop__list-gif">
            <img src="./static/images/giphy1.gif" alt="">
            <img src="./static/images/giphy8.gif" alt="">
            <img src="./static/images/giphy2.gif" alt="">
            <img src="./static/images/giphy11.gif" alt="">
        </section>
        <section class="laptop__list-logo">
            <img src="./static/images/logo-mac.png" alt="">
            <img src="./static/images/logo-asus.png" alt="">
            <img src="./static/images/logo-hp.png" alt="">
            <img src="./static/images/logo-msi.png" alt="">
            <img src="./static/images/logo-acer.png" alt="">
            <img src="./static/images/logo-dell.png" alt="">
        </section>
        <section>
            <div class="product-container swiper product-Swiper">
                <div class=" swiper-wrapper product-wrapper">
                    <div class="swiper-slide">
                        <div class="product-item">
                            <img class="product-img" alt="" src="./static/images/laptop-product.png" />
                            <b class="product-name">Macbook Air M1</b>
                            <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                        </div>
                    </div>

                </div>
                <img class="icon-obj swiper-button-prev" alt="" src="./static/images/btnback.svg" />
                <img class="icon-obj swiper-button-next"  alt="" src="./static/images/btnnext.svg" />
                <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
            </div>
        </section>
    </section>
</section>
<section class="accessory-container">
    <section class="accessory-title">
        <img class="laptop-girl" src="./static/images/girl-headphone.png" alt="">
        <b class="accessory-txt">Accessory</b>
        <img class="giphy-9" src="./static/images/giphy9.gif" alt="">
    </section>
    <section class="accessory__product-container">
        <section class="accessory__group-img">
            <img class="accessory__product-img" src="./static/images/headphone-pink.png" alt="">
            <img src="./static/images/block1.png" alt="">
        </section>
        <section class="accessory__list-item swiper product-Swiper">
            <div class=" swiper-wrapper product-wrapper">
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/headphone-white.png" />
                        <b class="product-name">Beats EP - Casque Filaire White</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>

            </div>
            <img class="icon-obj swiper-button-prev" alt="" src="./static/images/btnback.svg" />
            <img class="icon-obj swiper-button-next"  alt="" src="./static/images/btnnext.svg" />
            <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
        </section>
    </section>
    <section class="accessory__product-container">
        <section class="accessory__group-img">
            <img class="accessory__product-img" src="./static/images/mouse-blue.png" alt="" style="margin-left: 0%; margin-bottom:-10%;">
            <img src="./static/images/block1.png" alt="">
        </section>
        <section class="accessory__list-item swiper product-Swiper">
            <div class=" swiper-wrapper product-wrapper">
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/mouse-black.png" />
                        <b class="product-name">Logitech G703 Lightspeed Wireless</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
            </div>
            <img class="icon-obj swiper-button-prev" alt="" src="./static/images/btnback.svg" />
            <img class="icon-obj swiper-button-next"  alt="" src="./static/images/btnnext.svg" />
            <div class="swiper-pagination" style="margin-bottom: -0.3%;"></div>
        </section>
    </section>
    <section class="accessory__product-container">
        <section class="accessory__group-img">
            <img class="accessory__product-img" src="./static/images/keyboard-white.png" alt="" style="margin-left: 1%; margin-bottom:-5%;">
            <img src="./static/images/block1.png" alt="">
        </section>
        <section class="accessory__list-item swiper product-Swiper">
            <div class=" swiper-wrapper product-wrapper">
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
                <div class="swiper-slide">
                    <div class="product-item">
                        <img class="product-img" alt="" src="./static/images/keyboard.png" />
                        <b class="product-name">Eyooso K620 USB Machanical Gaming</b>
                        <img class="btn-buynow" alt="" src="./static/images/btnbuynow.svg" />
                    </div>
                </div>
            </div>
            <img class="icon-obj swiper-button-prev" alt="" src="./static/images/btnback.svg" />
            <img class="icon-obj swiper-button-next"  alt="" src="./static/images/btnnext.svg" />
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
</body>
</html>