<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/24/2023
  Time: 11:00 PM
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
    <link rel="stylesheet" href="<c:url value="/static/css/order-history.css"/>">
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
    <form class="history-menu row center" action="filter-order" method="get">
        button name="tab" value="ALL" class="history-menu-choose column center">
        <p>All</p>
        </button>
        <button name="tab" value="PENDING" class="history-menu-choose column center">
            <p>Pending</p>
        </button>
        <button name="tab" value="PROCESSING" class="history-menu-choose column center">
            <p>Processing</p>
        </button>
        <button name="tab" value="SHIPPED" class="history-menu-choose column center">
            <p>Shipped</p>
        </button>
        <button name="tab" value="DELIVERED" class="history-menu-choose column center">
            <p>Delivered</p>
        </button>
        <button name="tab" value="CANCELLED" class="history-menu-choose column center">
            <p>Cancelled</p>
        </button>
        <button name="tab" value="RETURNED" class="history-menu-choose column center">
            <p>Returned</p>
        </button>
        <button name="tab" value="REFUNDED" class="history-menu-choose column center">
            <p>Refunded</p>
        </button>
    </form>
    <div class="history-search column center">
        <p>If you already have a account, please log in to track your order. If you don't have a account, you can enter your information in the table below for tracking.</p>
        <form action="#" method="get" class="history-search-id row">
            <div class="history-search-id-input column">
                <input type="text" name="productID" placeholder=" ">
                <label>Order ID</label>
            </div>
            <input type="submit" value="Search" class="button-search">
        </form>
    </div>
    <div class="history-content center">
        <div class="product_history-list center column">
            <c:forEach var="item" items="${orders}">
                <div class="product_history-item column center">
                    <div class="product_history-order row">
                        <div class="product_history-order-left">
                            <p>Order ID: ${item.id}</p>
                        </div>
                        <div class="product_history-order-right row">
                            <p>Total:&nbsp;</p>
                            <p>10.989.800đ</p>
                        </div>
                    </div>

                    <c:forEach var="orderItem" items="${item.orderItems}">
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
                                    <strong>${orderItem.product.desc}</strong>
                                </td>
                                <td class="product_details-color">
                                    <span>${orderItem.product.color}</span>
                                </td>
                                <td class="product_details-code">
                                    <span>${orderItem.product.id}</span>
                                </td>
                            </tr>
                            <tr class="product_details-right column">
                                <td class="product_details-price">
                                    <span><strong>${orderItem.subTotal}</strong></span>
                                </td>
                                <td>&nbsp;</td>
                                <td>x${orderItem.quantity}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    </c:forEach>
                    <div class="product_history-controls row">
                        <div class="product_history-controls-left row">
                            <p>Completed</p>
                        </div>
                        <form class="product_history-controls-right row" id="controlForm" method="get">
                            <input type="hidden" name="orderId" value="${item.id}">
                            <c:if test="${item.status == 'PENDING'}">
                                <button class="button-cancel" name="status" value="CANCELLED" onclick="submitFormWithAction('change-order-status')">Cancel</button>
                            </c:if>
                            <c:if test="${item.status == 'SHIPPED'}">
                                <button class="button-return" name="status" value="RETURNED" onclick="submitFormWithAction('change-order-status')">Return</button>
                            </c:if>
                            <c:if test="${item.status == 'SHIPPED'}">
                                <button class="button-deliver" name="status" value="DELIVERED" onclick="submitFormWithAction('change-order-status')">Deliver</button>
                            </c:if>
                            <button class="button-details" onclick="submitControlForm('order-details')">Details</button>
                        </form>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </div>
    </div>
</section>
<footer class="center">
    <p>&copy; Copyright 2023</p>
</footer>
<script src="<c:url value="/static/js/history.js"/>" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>
