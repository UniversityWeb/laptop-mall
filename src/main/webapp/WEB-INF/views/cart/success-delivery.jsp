
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
    <link rel="stylesheet" href="<c:url value="/static/css/success-delivery.css"/>">
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
                <span class="process_step-number center"><ion-icon name="checkmark-outline"></ion-icon></span>
                <span class="process_step-title center">Payment Method</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center" style="background-color: #2189FF;">4</span>
                <span class="process_step-title center"><strong>Complete Order</strong></span>
            </li>
        </ul>
    </div>
    <div class="content row">
        <div class="content column center">
            <p class="success_text">Payment Success!</p>
            <ion-icon name="bag-check-outline"></ion-icon>
            <p class="thanks_text">Thanks you!</p>
            <p>Your order has been successfully placed</p>
            <form action="home-page" method="post" class="full center">
                <button class="button_shopping">Continue Shopping</button>
            </form>
        </div>
    </div>

</section>
<footer class="center">
    <p>&copy; Copyright 2023</p>
</footer>
<script src="" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>