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
<header class="center">
    <p style="color: #fff;">header nè</p>
</header>
<section class="content column">
    <div class="history-title center column">
        <h1>Ordered</h1>
        <hr>
    </div>
    <form class="history-menu row center">
        <button name="tab" value="1" class="history-menu-choose column center">
            <p>All</p>
        </button>
        <button name="tab" value="2" class="history-menu-choose column center">
            <p>Pending</p>
        </button>
        <button name="tab" value="3" class="history-menu-choose column center">
            <p>Processing</p>
        </button>
        <button name="tab" value="4" class="history-menu-choose column center">
            <p>Shipped</p>
        </button>
        <button name="tab" value="5" class="history-menu-choose column center">
            <p>Dilivered</p>
        </button>
        <button name="tab" value="6" class="history-menu-choose column center">
            <p>Canccelled</p>
        </button>
        <button name="tab" value="7" class="history-menu-choose column center">
            <p>Returned</p>
        </button>
        <button name="tab" value="8" class="history-menu-choose column center">
            <p>Refunded</p>
        </button>
        <button name="tab" value="9" class="history-menu-choose column center">
            <p>Completed</p>
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
