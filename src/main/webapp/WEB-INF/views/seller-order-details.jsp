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
    <div class="history_details-header row center">
        <form class="history_details-header-left center row" action="seller-orders" method="get">
            <button class="button-return center row">
                <ion-icon name="chevron-back-outline"></ion-icon>
                <p>RETURN</p>
            </button>
        </form>
        <div class="history_details-header-right row">
            <div class="history_details-order-id row">
                <p>ORDER ID:&nbsp;</p>
                <p>${orderHistory.id}</p>
            </div>
            <p>&nbsp;|&nbsp;</p>
            <div class="history_details-order-status row">
                <p>ORDER STATUS:&nbsp;</p>
                <p>${orderHistory.status}</p>
            </div>
            <p>&nbsp;|&nbsp;</p>
            <div class="history_details-order-status row">
                <p>ORDER DATE:&nbsp;</p>
                <p>${orderHistory.orderDate}</p>
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
                    <p>: ${orderHistory.customer.fullName}</p>
                </div>
                <div class="history_details-information-line row center">
                    <label>Phone Number</label>
                    <p>: ${orderHistory.customer.phoneNo}</p>
                </div>
                <div class="history_details-information-line row center">
                    <label>Address</label>
                    <p>: ${orderHistory.customer.address}</p>
                </div>
                <div class="history_details-information-line row center">
                    <label>Delivery Method</label>
                    <p>: ${orderHistory.deliveryMethod}</p>
                </div>
            </div>
            <hr>
            <ul class="order-process row center" id="order-process-container"  order-status="${orderHistory.status}" payment-status="${orderHistory.payment.status}">
                <li class="order-step column center" id="odered-status">
                    <span class="order_step-icon center"><ion-icon name="reader-outline"></ion-icon></span>
                    <span class="order_step-title">Ordered</span>
                </li>
                <li class="order_step column center" id="payment-status">
                    <span class="order_step-icon center"><ion-icon name="logo-usd"></ion-icon></span>
                    <span class="order_step-title">Paid</span>
                </li>
                <li class="order_step column center" id="shipping-status">
                    <span class="order_step-icon center"><ion-icon name="bag-check-outline"></ion-icon></span>
                    <span class="order_step-title">Shipped</span>
                </li>

                <li class="order_step column center" id="result-status">
                    <c:if test="${orderHistory.status != 'CANCELLED' and orderHistory.status != 'RETURNED'}">
                        <span class="order_step-icon center"><ion-icon name="download-outline"></ion-icon></span>
                        <span class="order_step-title">Delivered</span>
                    </c:if>
                    <c:if test="${orderHistory.status == 'CANCELLED'}">
                        <span class="order_step-icon center"><ion-icon name="sync-outline"></ion-icon></span>
                        <span class="order_step-title">Cancelled</span>
                    </c:if>
                    <c:if test="${orderHistory.status == 'RETURNED'}">
                        <span class="order_step-icon center"><ion-icon name="sync-outline"></ion-icon></span>
                        <span class="order_step-title">Returned</span>
                    </c:if>
                </li>
            </ul>
        </div>
    </div>
    <hr>
    <div class="history_cart center column">
        <div class="product_list">
            <c:forEach var="item" items="${orderHistory.orderItems}">
                <div class="product_item row center">
                    <table class="product_details">
                        <tr>
                            <div class="product_img-square center">
                                <img class="product_img-source" alt="${item.product.model}" src="<c:url value="${item.product.imageUrls[0]}"/>">
                            </div>
                        </tr>
                        <tbody class="row">
                        <tr class="product_details-left column">
                            <td class="product_details-title">
                                <strong>${item.product.model}</strong>
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
                                <span><strong>${item.product.getDiscountedPriceCurrentFormat()}</strong></span>
                            </td>
                            <td class="product_details-price-text right">
                                <span><del style="font-size: 0.9em">${item.product.getPriceCurrencyFormat()}</del></span>
                            </td>
                            <td>x${item.qty}</td>
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
                        <td class="history_cart-summary-right"><del>${orderHistory.totalOriginalAmountOfOrderCurrentFormat()}</del></td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Ship COD</td>
                        <td class="history_cart-summary-right">Free</td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Order total before discount</td>
                        <td class="history_cart-summary-right" style="font-weight: bold;">${orderHistory.totalDiscountedAmountOfOrderCurrentFormat()}</td>
                    </tr>
                    <tr>
                        <td class="history_cart-summary-left">Payment Method</td>
                        <td class="history_cart-summary-right">${orderHistory.payment.paymentMethod}</td>
                    </tr>
                </table>
            </div>
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