<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/static/css/cart.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/method-delivery.css"/>">
</head>
<body class="column">
<header class="row center">
    <div class="back_to_shop left">
        <form action="cart" method="post" class="center">
            <input type="hidden" name="action" value="Return Home">
            <button class="back_to_shop row left">
                <ion-icon name="chevron-back-outline"></ion-icon>
                <span> Back To Shop </span>
            </button>
        </form>
    </div>
    <h2>LaptopMall</h2>
    <div class="contact_shop right">
        <form action="cart" method="post" class="center">
            <input type="hidden" name="action" value="Contact">
            <button>
                <span> Contact </span>
                <ion-icon name="call-outline"></ion-icon>
            </button>
        </form>
    </div>
</header>
<section class="column center">
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
                <label>Full Name</label>
                <p>:&nbsp;${order.customer.fullName}</p>
                <label>Address</label>
                <p>:&nbsp;${order.customer.address}</p>
                <label>Phone Number</label>
                <p>:&nbsp;${order.customer.phoneNo}</p>
            </div>
            <hr>
            <h1>Payment Method:</h1>
            <div class="payment_method row" onclick="showPayment('cash_payment')">
                <p>Cash Payment</p>
                <ion-icon name="chevron-down-outline"></ion-icon>
            </div>
            <div class="cash_payment payment_method-content">
                <input type="checkbox" class="check_box_policy" name="acceptPolicy" required> I agree to the policies and terms.
            </div>
            <div class="payment_method row" onclick="showPayment('momo_payment')">
                <p>MOMO Payment</p>
                <ion-icon name="chevron-down-outline"></ion-icon>
            </div>
            <div class="momo_payment payment_method-content">
                <img src="#" alt="Mã QR thanh toán">
            </div>
        </div>
        <div class="content_right">
            <div class="content_right-container">
                <h1>Order Summary</h1>
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
                                <a href="product_details-link">
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
    <%--                            Số tiền sau giảm giá nếu có--%>
                                <c:choose>
                                    <c:when test="${item.product.priceDiscounted > 0}">
                                        <span><strong>${priceDiscounted}</strong></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span><strong>${item.product.price}</strong></span>
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
                        <%--                    Chỉ hiện tổng tiền nếu không có mặt hàng nào giảm giá--%>
                        <span class="left"><strong>Total order price:</strong></span>
                        <span class="right"><strong>${priceDiscounted}</strong></span>
                    </div>
                    <div class="sumary_invoice_line full">
                        <span class="left">Order total before discount:</span>
                        <span class="right">13.989.900đ</span>
                    </div>
                    <div class="sumary_invoice_line full">
                        <span class="left">Total amount after discount:</span>
                        <span class="right">3.000.000đ</span>
                    </div>
                </div>
                <hr>
                <form action="success-delivery" method="post" class="full center">
                    <input type="hidden" name="action" value="Success Payment">
                    <input type="hidden" name="paymentMethod">
                    <button class="button_payment">Payment</button>
                </form>

                <form action="information" method="post" class="full center">
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
<script src="<c:url value="/static/js/method-delivery.js"/>" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>