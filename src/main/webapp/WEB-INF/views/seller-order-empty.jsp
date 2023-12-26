<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/24/2023
  Time: 11:19 PM
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
    <link rel="stylesheet" href="<c:url value="/static/css/order-history-empty.css"/>">
</head>
<body>

<jsp:include page="seller-navbar.jsp"></jsp:include>
<section class="content column">
    <div style="height: 100px; width: 100px"></div>
    <div class="history-title center column">
        <h1>Ordered</h1>
        <hr>
    </div>
    <form class="history-menu row center" action="seller-orders" method="get">
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
        <img src="<c:url value="/static/images/empty.gif"/>" alt="You have no order yet">
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
