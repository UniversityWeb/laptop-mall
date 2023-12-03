<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <title>${prod.category} | ${prod.model}</title>
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/product-details.css"/>">

</head>
<body>
<input type="checkbox" id="check">
<jsp:include page="navbar.jsp"></jsp:include>
<nav style="margin-top: var(--nav-height);">
    <div class="navigation">
        <a href="#prod-features">Features</a>
        <a href="#prod-specifications">Specifications</a>
        <a href="#prod-comparisons">Comparisons</a>
    </div>
    <label class="btn_collapse" for="check">
        <i class="fas fa-bars menu-btn"></i>
        <i class="fas fa-times close-btn"></i>
    </label>
</nav >
<section class="product-detail__container">
    <section id="prod-features">
        <div class="container">
            <section class="prod_img-content">
                <ul class="prod_img-list">
                    <c:forEach var="imgUrl" items="${prod.imageUrls}">
                        <li class="prod_img-item">
                            <img src="<c:url value="${imgUrl}"/>" alt="item">
                        </li>
                    </c:forEach>

                    <li class="prod_img-item">
                        <img src="<c:url value="/static/images/headphone-white.png"/>" alt="item">
                    </li>
                    <li class="prod_img-item">
                        <img src="<c:url value="/static/images/headphone-white.png"/>" alt="item">
                    </li>
                </ul>
                <div class="prod_img-full">
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
                    <c:choose>
                        <c:when test="${prod.category eq 'LAPTOP'}">
                            <c:set var="laptop" value="${prod}" />

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">
                                    Processor
                                </span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">CPU Name:</span>
                                        <span class="item-values">${laptop.cpuName}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Cores/Threads:</span>
                                        <span class="item-values">${laptop.cpuCores}/${laptop.cpuThreads}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Speed/Max Speed:</span>
                                        <span class="item-values">${laptop.cpuSpeed}/${laptop.cpuMaxSpeed}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Cache:</span>
                                        <span class="item-values">${laptop.cpuCache}</span>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">
                                    RAM, ROM
                                </span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">RAM Size / Max Size:</span>
                                        <span class="item-values">${laptop.ramSize}/${laptop.ramMaxSupport}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">RAM Type:</span>
                                        <span class="item-values">${laptop.ramType}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Bus Speed:</span>
                                        <span class="item-values">${laptop.ramBusSpeed}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">ROM Size:</span>
                                        <span class="item-values">${laptop.romSize}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">ROM Type:</span>
                                        <span class="item-values">${laptop.romType}</span>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">
                                    Screen
                                </span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Screen Size:</span>
                                        <span class="item-values">${laptop.screenSize}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Screen Resolution:</span>
                                        <span class="item-values">${laptop.screenResolution}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Refresh Rate:</span>
                                        <span class="item-values">${laptop.screenRefreshRate}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Technology:</span>
                                        <span class="item-values">${laptop.screenTechnology}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Brightness:</span>
                                        <span class="item-values">${laptop.brightness}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Anti Glare:</span>
                                        <span class="item-values">${laptop.antiGlare}</span>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">
                                    Other Information
                                </span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Graphics Card:</span>
                                        <span class="item-values">${laptop.graphicsCard}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Weight:</span>
                                        <span class="item-values">${laptop.weight}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Material:</span>
                                        <span class="item-values">${laptop.material}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">OS:</span>
                                        <span class="item-values">${laptop.operatingSystem}</span>
                                    </div>
                                </div>
                            </div>
                        </c:when>

                        <c:when test="${prod.category eq 'MECHANICAL_KEYBOARD'}">
                            <c:set var="keyboard" value="${prod}" />

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">
                                    Physical Specifications
                                </span>
                                <div class="confi-details">

                                    <div class="confi-item">
                                        <span class="item-name">Switch Type:</span>
                                        <span class="item-values">${keyboard.switchType}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Layout:</span>
                                        <span class="item-values">${keyboard.layout}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Key Count:</span>
                                        <span class="item-values">${keyboard.keyCount}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Keycap Material:</span>
                                        <span class="item-values">${keyboard.keycapMaterial}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Battery Type:</span>
                                        <span class="item-values">${keyboard.batteryType}</span>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">
                                    Connectivity and Features
                                </span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Compatibilities:</span>
                                        <ul class="item-values">
                                            <c:forEach var="compatibility" items="${keyboard.compatibilities}">
                                                <li>${compatibility}</li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Connections:</span>
                                        <ul class="item-values">
                                            <c:forEach var="conn" items="${keyboard.connections}">
                                                <li>${conn}</li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Cable Length:</span>
                                        <span class="item-values">${keyboard.cableLength}</span>
                                    </div>
                                </div>
                            </div>
                        </c:when>

                        <c:when test="${prod.category eq 'MONITOR'}">
                            <c:set var="monitor" value="${prod}" />
                            <div class="prod-specification__content">
                                <span class="title-prod-confi">Configuration Information</span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Screen Size:</span>
                                        <span class="item-values">${monitor.screenSize}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Resolution:</span>
                                        <span class="item-values">${monitor.resolution}</span>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">Screen Technology</span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Panel Type:</span>
                                        <span class="item-values">${monitor.panelType}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Refresh Rate:</span>
                                        <span class="item-values">${monitor.refreshRate}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Touch Screen:</span>
                                        <span class="item-values">${monitor.touchScreen}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">HDR Supported:</span>
                                        <span class="item-values">${monitor.hdrSupported}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Built In Speakers:</span>
                                        <span class="item-values">${monitor.builtInSpeakers}</span>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">Eye Care and Connectivity</span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Eye Care Technology:</span>
                                        <span class="item-values">${monitor.eyeCareTechnology}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Brightness:</span>
                                        <span class="item-values">${monitor.brightness}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Connections:</span>
                                        <ul class="item-values">
                                            <c:forEach var="conn" items="${keyboard.connections}">
                                                <li>${conn}</li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="prod-specification__content">
                                <span class="title-prod-confi">Power and Size</span>
                                <div class="confi-details">
                                    <div class="confi-item">
                                        <span class="item-name">Power Consumption:</span>
                                        <span class="item-values">${monitor.powerConsumption}</span>
                                    </div>
                                    <div class="confi-item">
                                        <span class="item-name">Weight:</span>
                                        <span class="item-values">${monitor.weight}</span>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                    </c:choose>


                    <div class="prod-specification__content">
                        <span class="title-prod-confi">Origin and Brand</span>
                        <div class="confi-details">
                            <div class="confi-item">
                                <span class="item-name">Brand:</span>
                                <span class="item-values">${prod.brand}</span>
                            </div>
                            <div class="confi-item">
                                <span class="item-name">Release Year:</span>
                                <span class="item-values">${prod.releaseYear}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <div class="prod_basic_info">
            <div class="brand-name">
                ${prod.brand}
            </div>
            <div class="group-basic-info">
                <div class="prod__id-content">
                    <input type="text" name="" id="prod-id" value=" ${prod.id}">
                    <button onclick="copyToClipboard()"><i class="fa-solid fa-copy"></i></button>
                </div>
                <span class="prod-name">
                    ${prod.model}
                </span>
                <div class="product-attributes">
                        <span class="product-attributes__name">
                            Version
                        </span>
                    <ul class="product-attribute__values">
                        <li class="prod-value__item">
                            ${prod.version}
                        </li>
                    </ul>
                </div>
                <div class="product-attributes">
                        <span class="product-attributes__name">
                            Color
                        </span>
                    <ul class="product-attribute__values">
                        <li class="prod-value__item">
                            ${prod.color}
                        </li>
                    </ul>
                </div>
                <div class="product-attributes">
                        <span class="product-attributes__name">
                            Category
                        </span>
                    <ul class="product-attribute__values">
                        <li class="prod-value__item">
                            ${prod.category}
                        </li>
                    </ul>
                </div>
                <div class="amount-prod">
                    <span class="amount-title">Amount</span>
                    <div class="amount-content">
                        <button id="subBtn" class="sub-btn" onclick="decreaseQtyOfProd()">
                            <i class="fa-solid fa-minus"></i>
                        </button>
                        <input type="text" name="" id="input-qty" class="amount-value"
                               value="1" oninput="validateAmountInput(this)">
                        <button id="plusBtn" class="plus-btn" onclick="increaseQtyOfProd(${prod.stockQty})">
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