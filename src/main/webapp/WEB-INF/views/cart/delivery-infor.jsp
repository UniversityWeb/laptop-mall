<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/30/2023
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Delivery Information</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/static/css/cart.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/delivery-infor.css"/>">
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
                <span class="process_step-number center"style="background-color: #2189FF;">2</span>
                <span class="process_step-title center"><strong>Shipping Information</strong></span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">3</span>
                <span class="process_step-title center">Payment Method</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">4</span>
                <span class="process_step-title center">Completed Order</span>
            </li>
        </ul>
    </div>
    <div class="content row">
        <div class="content_left">
            <form class="information_deliver" id="form-infor" action="check-infor-delivery" method="post">
                <h1> Payment: </h1>
                <div class="information_deliver-only-line">
                    <input class="information_deliver-text" type="email" name="email"  value="${order.customer.email}" placeholder=" " readonly>
                    <p class="information_deliver-label-text"> Email </p>
                </div>
                <h1> Delivery Information Details: </h1>
                <c:if test="${param.error == 'True'}">
                    <p><i style="color: red; font-size: 0.9em;">Please choose delivery method</i></p>
                </c:if>
                <div class="information_deliver-method row">
                    <div class="information_deliver-input row left">
                        <input type="radio" name="deliveryMethod" value="Home Delivery" required>
                        <p>Home Delivery</p>
                    </div>
                    <div class="information_deliver-input row left">
                        <input type="radio" name="deliveryMethod" value="Receive at Location" required>
                        <p>Receive at Location</p>
                    </div>
                </div>
                <div class="information_deliver-line row">
                    <div class="information_deliver-input column">
                        <input class="information_deliver-text" type="text" name="fullName" value="${order.customer.fullName}" placeholder=" " readonly>
                        <p class="information_deliver-label-text"> Full Name </p>
                    </div>
                    <div class="information_deliver-input column">
                        <input class="information_deliver-text" type="tel" name="phoneNo" value="${order.customer.phoneNo}" placeholder=" " readonly>
                        <p class="information_deliver-label-text"> Contact Number* </p>
                    </div>
<%--                    <div class="information_deliver-input column">--%>
<%--                        <select class="information_deliver-text" name="gender" required>--%>
<%--                            <option disabled selected hidden></option>--%>
<%--                            <option value="MALE">Male</option>--%>
<%--                            <option value="FEMALE">Female</option>--%>
<%--                        </select>--%>
<%--                        <p class="information_deliver-label-text"> Gender* </p>--%>
<%--                    </div>--%>
                </div>

<%--                <div class="information_deliver-line row">--%>
<%--                    <div class="information_deliver-input column">--%>
<%--                        <input class="information_deliver-text" type="tel" name="phoneNo" value="${order.customer.phoneNo}" placeholder=" " readonly>--%>
<%--                        <p class="information_deliver-label-text"> Contact Number* </p>--%>
<%--                    </div>--%>
<%--                    <div class="information_deliver-input column">--%>
<%--                        &nbsp;--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="information_deliver-only-line">
                    <input class="information_deliver-text" name="address" value="${order.customer.address}" placeholder=" " style="width: 730px;" readonly>
                    <p class="information_deliver-label-text" style="width: 710px;"> Address </p>
                </div>
                <p>Notes upon receiving</p>
                <textarea class="note-box" name="note" value="${order.note}"></textarea>
            </form>
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
                <div class="full center">
                    <button class="button_payment" onclick="submitForm('form-infor')">Payment</button>
                </div>
                <form action="cart" method="post" class="full center">
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
