<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <title>Payment Method</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/static/css/cart.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/payment-method.css"/>">
</head>
<body class="column">
<jsp:include page="../navbar.jsp"></jsp:include>
<section class="column center">
    <div style="height: 70px; width: 100px"></div>
    <div class="process_payment">
        <ul class="process_list center row">
            <li class="process_step column center">
                <span class="process_step-number center"><ion-icon name="checkmark-outline"></ion-icon></span>
                <span class="process_step-title center">Check Cart</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center"><ion-icon name="checkmark-outline"></ion-icon></span>
                <span class="process_step-title center">Shipping Information</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center" style="background-color: #2189FF;">3</span>
                <span class="process_step-title center"><strong>Method Payment</strong></span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">4</span>
                <span class="process_step-title center">Complete Order</span>
            </li>
        </ul>
    </div>
    <div class="content row">
        <div class="content_left">
            <h1>Delivery Information Details:</h1>
            <div class="information_delivery">
                <label>Email</label>
                <p>:&nbsp;${order.customer.email}</p>
                <label>Full Name</label>
                <p>:&nbsp;${order.customer.fullName}</p>
                <label>Address</label>
                <p>:&nbsp;${order.customer.address}</p>
                <label>Phone Number</label>
                <p>:&nbsp;${order.customer.phoneNo}</p>
                <label>Delivery Method</label>
                <p>:&nbsp;${order.deliveryMethod}</p>
            </div>
            <hr>
            <h1>Payment Method:</h1>
            <c:if test="${param.error == 'True'}">
                <p><i style="color: red; font-size: 1.1em">Please choose payment method!</i></p>
            </c:if>
            <form class="payment-method row" id="form-method" action="payment" method="post">
                <div class="payment-method-input row left">
                    <input type="radio" name="paymentMethod" value="CASH_ON_DELIVERY">
                    <p>Cash Payment</p>
                </div>
                <div class="payment-method-input row left">
                    <input type="radio" name="paymentMethod" value="MOMO">
                    <p>MOMO Payment</p>
                </div>
                <div class="payment-method-input row left">
                    <input type="radio" name="paymentMethod" value="VN_PAY">
                    <p>VNPAY payment</p>
                </div>
            </form>
        </div>
        <div class="content_right">
            <div class="content_right-container">
                <h1>Order Summary</h1>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:forEach var="item" items="${cart}">
                <div class="product_item full row">
                    <table class="product_details full">
                        <tr class="full">
                            <div class="product_img">
                                <div class="product_img-square center">
                                    <img class="product_img-source" alt="${item.product.model}" src="${item.product.imageUrls[0]}">
                                </div>
                            </div>
                        </tr>
                        <tbody class="row">
                        <tr class="product_details-left column">
                            <td class="product_details-title left">
                                <a href="get-prod-by-id?id=${item.product.id}">
                                    <strong>${item.product.model}</strong>
                                </a>
                            </td>
                            <td class="product_details-color left">
                                <span>${item.product.color}</span>
                            </td>
                            <td class="product_details-code left">
                                <span>${item.product.version}</span>
                            </td>
                        </tr>
                        <tr class="product_details-right column">
                            <td class="product_details-price right">
                                <c:choose>
                                    <c:when test="${item.product.discountPercent > 0 and item.product.discountPercent != null}">
                                        <span><strong>${item.totalDiscountedAmountOfCartItemCurrentFormat()}</strong></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span><strong>${item.totalOriginalAmountOfCartItemCurrentFormat()}</strong></span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <hr>
                </c:forEach>
                <div class="sumary_invoice full">
                    <div class="sumary_invoice_line full">
                        <span class="left"><strong>Total order price:</strong></span>
                        <span class="right"><strong>${totalDiscountedAmount}</strong></span>
                    </div>
                    <div class="sumary_invoice_line full">
                        <span class="left">Order total before discount:</span>
                        <span class="right">${totalOriginalAmount}</span>
                    </div>
                    <div class="sumary_invoice_line full">
                        <span class="left">Total amount after discount:</span>
                        <span class="right">${totalDiscountAmount}</span>
                    </div>
                </div>
                <hr>
                <div class="full center">
                    <button class="button_payment" onclick="submitForm('form-method')">Payment</button>
                </div>
                <form action="delivery-infor" method="post" class="full center">
                    <input type="hidden" name="action" value="Shipping Information">
                    <button class="button_return">Return</button>
                </form>
            </div>
        </div>
    </div>
</section>
<footer class="center">
    <p>&copy; Copyright 2023</p>
</footer>
<script src="<c:url value="/static/js/cart.js"/>" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>