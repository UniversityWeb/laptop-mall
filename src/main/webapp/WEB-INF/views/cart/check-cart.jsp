<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Your Cart</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/static/css/cart.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/check-cart.css"/>">
</head>
<body class="column">
<header class="row center">
    <div class="back_to_shop left" style="margin-top: 15px">
        <form action="home-page" method="post" class="center">
            <input type="hidden" name="action" value="Return Home">
            <button class="back_to_shop row left">
                <ion-icon name="chevron-back-outline"></ion-icon>
                <span> Back To Shop </span>
            </button>
        </form>
    </div>
    <h2>LaptopMall</h2>
    <div class="contact_shop right">
        &nbsp;
    </div>
</header>
<section class="column center">
    <div class="process_payment">
        <ul class="process_list center row">
            <li class="process_step column center">
                <span class="process_step-number center" style="background-color: #2189FF;">1</span>
                <span class="process_step-title center"><strong>Check Cart</strong></span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">2</span>
                <span class="process_step-title center">Shipping Information</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">3</span>
                <span class="process_step-title center">Payment Method</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">4</span>
                <span class="process_step-title center">Complete Order</span>
            </li>
        </ul>
    </div>
    <div class="content row">
        <div class="content_left">
            <div class="product_list full">
                <div class="your_cart full left row">
                    <h3 class="your_cart-title">Your Cart</h3>&nbsp;
                    <span class="your_cart-number">(${qtyItems} items)</span>
                </div>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:forEach var="item" items="${cart}">
                <div class="product_item full row">
                    <table class="product_details full">
                        <tr class="full">
                            <a class="product_img" href="#">
                                <div class="product_img-square center">
                                    <img class="product_img-source" alt="${item.product.model}" src="app/prod/${item.product.id}-0.jpg">
                                </div>
                            </a>
                        </tr>
                        <tbody class="row">
                        <tr class="product_details-left column">
                            <td class="product_details-title left">
                                <a href="#">
                                    <strong>${item.product.model}</strong>
                                </a>
                            </td>
                            <td class="product_details-color left">
                                <span>${item.product.color}</span>
                            </td>
                            <td class="product_details-code left">
                                <span>${item.product.version}</span>
                            </td>
                            <td class="product_details-number left">
                                <form action="update" class="product_details-number-count row" method="post" id="quantity-form">
                                    <input type="hidden" name="productId"
                                    value="<c:out value='${item.product.id}'/>">
                                    <button name="buttonUpdate" value="-1" class="button-minus">
                                        <ion-icon name="remove-outline"></ion-icon>
                                    </button>
                                    <input type="text" name="quantity" value="<c:out value='${item.qty}'/>" onchange="submitQuantity()">
                                    <button name="buttonUpdate" value="1" class="button-add">
                                        <ion-icon name="add-outline"></ion-icon>
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <tr class="product_details-right column">
                            <c:choose>
                                <c:when test="${item.product.priceDiscounted > 0}">
                                <td class="product_details-price right">
                                    <span><strong>${item.totalDiscountedAmountOfCartItemCurrentFormat()}</strong></span>
                                </td>
                                <td class="product_details-price-discount right">
                                    <span>${item.totalDiscountAmountOfCartItemCurrentFormat()}</span>
                                </td>
                                <td class="product_details-price-text right">
                                    <span>Discounted</span>
                                </td>
                                </c:when>
                                <c:otherwise>
                                    <td class="product_details-price right">
                                        <span><strong>${item.totalDiscountAmountOfCartItemCurrentFormat()}</strong></span>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                            <td class="product_details-remove right">
                                <form action="delete" class="product_details-number-count row" method="post">
                                    <input type="hidden" name="productCode"
                                    value="<c:out value='${item.product.id}'/>">
                                    <input type="hidden" name="productNumber" value="0">
                                    <button name="action" value="Remove Item" class="button-remove">
                                        <ion-icon name="trash-outline"></ion-icon>
                                    </button>
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <hr>
                </c:forEach>
            </div>
        </div>
        <div class="content_right">
            <div class="content_right-container">
                <h3 class="cart_sumary-title">Order Summary</h3>
                <div class="cart_sumary-policy">
                    <label class="cart_sumary-policy-title">Authentic Laptop Mall's Benefits:</label>
                    <div class="cart_sumary-policy-line">
                        <a href="#">
                            <ion-icon class="cart_sumary-icon" name="cube-outline"></ion-icon>
                            Free nationwide shipping.
                        </a>
                    </div>
                    <div class="cart_sumary-policy-line">
                        <a href="#">
                            <ion-icon class="cart_sumary-icon" name="wallet-outline"></ion-icon>
                            Exchange the product according to the policy within 14 days.
                        </a>
                    </div>
                </div>
                <div class="cart_sumary-support">
                    <label class="cart_sumary-support-title"><strong>Payment support:</strong></label>
                    <div class="cart_sumary-support-line left row">
                        <ion-icon name="checkmark-outline"></ion-icon>
                        Interest-free installment with credit card.
                    </div>
                    <div class="cart_sumary-support-line left row">
                        <ion-icon name="checkmark-outline"></ion-icon>
                        Payment upon receipt.
                    </div>
                    <div class="cart_sumary-support-line left row">
                        <ion-icon name="checkmark-outline"></ion-icon>
                        Payment at the store.
                    </div>
                    <div class="cart_sumary-support-line left row">
                            <ion-icon name="checkmark-outline"></ion-icon>
                            Payment via Momo.
                    </div>
                </div>
                <div class="sumary_invoice full">
                    <div class="sumary_invoice_line full">
                        <span class="left"><strong>Total discounted amount:</strong></span>
                        <span class="right"><strong>${totalDiscountedAmount}</strong></span>
                    </div>
                    <div class="sumary_invoice_line full">
                        <span class="left">Total original amount:</span>
                        <span class="right">${totalOriginalAmount}</span>
                    </div>
                    <div class="sumary_invoice_line full">
                        <span class="left">Total discount amount:</span>
                        <span class="right">${totalDiscountAmount}</span>
                    </div>
                </div>
                <hr>
                <form action="delivery-infor" method="post" class="full center">
                    <button class="button_payment">Payment</button>
                </form>
            </div>
        </div>
    </div>

</section>
<footer class="center">
    <p>&copy; Copyright 2023</p>
</footer>
<script src="<c:url value="/static/js/check-cart.js"/>" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>