<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/24/2023
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/static/css/history.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/css/order-history-details.css"/>">
</head>
<body>
<header class="center">
    <p style="color: #fff;">header nè</p>
</header>
<section class="content column">
    <div class="history-title center column">
        <h1>Ordered</h1>
        <hr>
    </div>
    <div class="history-menu row center">
        <button class="history-menu-choose column center">
            <p style="border-bottom: 3px solid #000;">All</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Pending</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Processing</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Shipped</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Dilivered</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Canccelled</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Returned</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Refunded</p>
        </button>
        <button class="history-menu-choose column center">
            <p>Completed</p>
        </button>
    </div>
    <div class="history_details-header row center">
        <form class="history_details-header-left center row">
            <button class="button-return center row">
                <ion-icon name="chevron-back-outline"></ion-icon>
                <p>RETURN</p>
            </button>
        </form>
        <div class="history_details-header-right row">
            <div class="history_details-order-id row">
                <p>ORDER ID:&nbsp;</p>
                <p>${order.id}</p>
            </div>
            <p>&nbsp;|&nbsp;</p>
            <div class="history_details-order-status row">
                <p>ORDER STATUS:&nbsp;</p>
                <p>${order.statusName}</p>
            </div>
        </div>
    </div>
    <hr>
    <div class="history_details column">
        <h1>Order Details</h1>
        <div class="history_details-content row">
            <div class="history_details-information column">
                <div class="history_details-information-line row center">
                    <label>Full Name</label>
                    <p>: ${order.customer.fullName}</p>
                </div>
                <div class="history_details-information-line row center">
                    <label>Phone Number</label>
                    <p>: ${order.customer.phoneNo}</p>
                </div>
                <div class="history_details-information-line row center">
                    <label>Address</label>
                    <p>: ${order.customer.address}</p>
                </div>
                <div class="history_details-information-line row center">
                    <label>Delivery Method</label>
                    <p>: ${order.customer.deliveryMethod}</p>
                </div>
            </div>
            <hr>
            <ul class="order-process row center">
                <li class="order-step column center">
                    <span class="order_step-icon center"><ion-icon name="reader-outline"></ion-icon></span>
                    <span class="order_step-title">Ordered</span>
                </li>
                <li class="order_step column center">
                    <span class="order_step-icon center"><ion-icon name="checkmark-circle-outline"></ion-icon></span>
                    <span class="order_step-title">Order Confirmed</span>
                </li>
                <li class="order_step column center">
                    <span class="order_step-icon center"><ion-icon name="card-outline"></ion-icon></span>
                    <span class="order_step-title">Paid</span>
                </li>
                <li class="order_step column center">
                    <span class="order_step-icon center"><ion-icon name="download-outline"></ion-icon></span>
                    <span class="order_step-title">Completed</span>
                </li>
            </ul>
        </div>
    </div>
    <hr>
    <div class="history_cart center column">
        <div class="product_list">

            <c:forEach var="item" items="${order.orderItems}">
            <div class="product_item row center">
                <table class="product_details">
                    <tr>
                        <div class="product_img-square center">
                            <img class="product_img-source" alt="productCode" src="productCode.webp">
                        </div>
                    </tr>
                    <tbody class="row">
                    <tr class="product_details-left column">
                        <td class="product_details-title">
                            <strong>${item.product.decs}</strong>
                        </td>
                        <td class="product_details-color">
                            <span>${item.product.color}</span>
                        </td>
                        <td class="product_details-code">
                            <span>${item.product.id}</span>
                        </td>
                    </tr>
                    <tr class="product_details-right column">
                        <td class="product_details-price">
                            <span><strong>${item.subTotal}</strong></span>
                        </td>
                        <td class="product_details-price-text right">
                            <span><del>${item.product.price}</del></span>
                        </td>
                        <td>x1</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr>
            </c:forEach>
            <div class="history_cart-summary">
                <table>
                    <tr>
                        <td class="history_cart-summary-left">Order Total</td>
                        <td class="history_cart-summary-right">13.989.800đ</td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Ship COD</td>
                        <td class="history_cart-summary-right">Free</td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Discount</td>
                        <td class="history_cart-summary-right">3.000.000đ</td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Order total before discount</td>
                        <td class="history_cart-summary-right" style="font-weight: bold;">10.989.800đ</td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Payment Method</td>
                        <td class="history_cart-summary-right">${order.payment.method}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>
<footer class="center">
    <p>&copy; Copyright 2023</p>
</footer>
<script src="" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>