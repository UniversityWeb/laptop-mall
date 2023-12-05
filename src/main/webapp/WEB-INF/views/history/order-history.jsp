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

<jsp:include page="../navbar.jsp"></jsp:include>
<section class="content column">
    <div style="height: 100px; width: 100px"></div>
    <div class="history-title center column">
        <h1>Ordered</h1>
        <hr>
    </div>
    <form class="history-menu row center" action="history" method="get">
        <button name="tab" value="ALL" class="history-menu-choose column center">
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
    <div class="history-content center">
        <div class="product_history-list center column">
            <c:forEach var="item" items="${ordersHistory}">
                <div class="product_history-item column center">
                    <div class="product_history-order row">
                        <div class="product_history-order-left">
                            <p>Order ID: ${item.id}</p>
                        </div>
                        <div class="product_history-order-right row">
                            <p>Total:&nbsp;</p>
                            <p>${item.totalDiscountedAmountOfOrderCurrentFormat()}</p>
                        </div>
                    </div>

                    <c:forEach var="orderItem" items="${item.orderItems}">
                    <div class="product_item row center">
                        <table class="product_details">
                            <tr>
                                <div class="product_img-square center">
                                        <img class="product_img-source" alt="${orderItem.product.model}" src="<c:url value="${orderItem.product.imageUrls[0]}"/>">
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
                                    <span><strong>${orderItem.getCurrPiceCurrentFormat()}</strong></span>
                                </td>
                                <td>&nbsp;</td>
                                <td>x${orderItem.qty}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    </c:forEach>
                    <div class="product_history-controls row">
                        <div class="product_history-controls-left row">
                            <p>${item.status}</p>
                        </div>
                        <div class="product_history-controls-right row">
                            <form id="${item.id}" method="post">
                                <input type="hidden" name="orderId" value="${item.id}">
                            <c:if test="${item.status == 'PENDING'}">
                                <button class="button-cancel" name="status" value="CANCELLED" onclick="submitFormWithAction('${item.id}','change-order-status')">Cancel</button>
                            </c:if>
                            <c:if test="${item.status == 'SHIPPED'}">
                                <button class="button-return" name="status" value="RETURNED" onclick="submitFormWithAction('${item.id}','change-order-status')">Return</button>
                                <button class="button-deliver" name="status" value="DELIVERED" onclick="submitFormWithAction('${item.id}','change-order-status')">Deliver</button>
                            </c:if>
                            <button class="button-details" onclick="submitFormWithAction('${item.id}','order-details')">Details</button>
                            </form>
                        </div>
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
