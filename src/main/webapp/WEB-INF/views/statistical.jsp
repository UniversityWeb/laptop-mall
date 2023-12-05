<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/4/2023
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Statistical</title>
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/static/css/statistical.css"/>">
</head>
<body>
<jsp:include page="seller-navbar.jsp"></jsp:include>
<div style="height: 80px; width: 100px"></div>
<form class="content-controll" action="statistical" method="get" id="control-form">
    <select name="selectedMonth" id="selectedMonth" onchange="submitControlForm()">
        <c:forEach var="month" begin="1" end="12">
            <option value="${month}" ${param.selectedMonth == month ? 'selected' : ''}>
                <c:out value="${monthNames[month-1]}"/>
            </option>
        </c:forEach>
    </select>
    <select name="selectedYear" id="selectedYear"  onchange="submitControlForm()">
        <c:forEach var="year" begin="2020" end="<%= Calendar.getInstance().get(Calendar.YEAR) %>">
            <option value="${year}" ${param.selectedYear == year ? 'selected' : ''}>
                    ${year}
            </option>
        </c:forEach>
    </select>
</form>
<hr>
<section class="content">
    <div class="content-row">
        <div class="content-column">
            <div class="content-column">
                <div class="revenue_container">
                    <div class="revenue_container-line">
                        <p class="revenue_container-item revenue-title"><strong>REVENUE</strong></p>
                    </div>
                    <div class="revenue_container-line">
                        <p class="revenue_container-item revenue-total">${totalRevenue}</p>
                        <ion-icon name="bar-chart-outline" class="revenue_container-item"></ion-icon>
                    </div>
                    <div class="revenue_container-line">
                        &nbsp;
                    </div>
                </div>
                <div class="order_container">
                    <div class="order_container-line">
                        <p class="order_container-item order-title"><strong>ORDERS</strong></p>
                    </div>
                    <div class="order_container-line">
                        <p class="order_container-item order-total">${totalOrder}</p>
                        <ion-icon name="bag-handle-outline" class="order_container-item"></ion-icon>
                    </div>
                    <div class="order_container-line">
                        &nbsp;
                    </div>
                </div>
            </div>
            <div class="order-by-status-container">
                <p class="chart-title">ORDER BY STATUS</p>
                <canvas id="order-by-status_chart" style="width:100%;max-width:550px"></canvas>
            </div>
        </div>
        <div class="content-column">
            <div class="top_best_sell-container">
                <p class="chart-title">TOP BEST-SELLING PRODUCTS</p>
                <canvas id="top_best_sell_chart" style="width:100%;max-width:550px"></canvas>
            </div>
            <div class="top_least_sell-container">
                <p class="chart-title">TOP LEAST-SELLING PRODUCTS</p>
                <canvas id="top_least_sell_chart" style="width:100%;max-width:550px"></canvas>
            </div>
        </div>
    </div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function (){
        var orderStatusType = <%= request.getAttribute("orderStatuses") %>;
        var orderStatusData = <%= request.getAttribute("orderStatusValues") %>;

        var topBestSellName = <%= request.getAttribute("topBestSellProductsName") %>;
        var topBestSellData = <%= request.getAttribute("topBestSellProductsQty") %>;

        var topCustomerName = <%= request.getAttribute("topLeastSellProductsName") %>;
        var topCustomerData = <%= request.getAttribute("topLeastSellProductsQty") %>;

        const barStatusColors = ["#2189FF", "#459bfd", "#68aeff", "#76b6ff", "#97c8ff", "#a5cdfc","#b8d9ff"];
        const barTopColors = ["#2189FF", "#3694ff","#459bfd","#459bfd", "#68aeff", "#76b6ff","#88bffe","#97c8ff", "#a5cdfc","#b8d9ff"];

        new Chart("order-by-status_chart", {
            type: "pie",
            data: {
                labels: orderStatusType,
                datasets: [{
                    backgroundColor: barStatusColors,
                    data: orderStatusData
                }]
            },
            options: {
                interaction: {
                    mode: 'nearest'
                },
                legend: {
                    position: 'right'
                },
                scales: {
                    y: {
                        display: true,
                        beginAtZero: true,
                        text: "Order No"
                    }
                }
            }
        });


        new Chart("top_best_sell_chart", {
            type: "horizontalBar",
            data: {
                labels: topBestSellName,
                datasets: [{
                    backgroundColor: barTopColors,
                    data: topBestSellData
                }]
            },
            options: {
                legend: {display: false},
                scales: {
                    y: {
                        display: true,
                        beginAtZero: true
                    }
                }
            }
        });

        new Chart("top_least_sell_chart", {
            type: "horizontalBar",
            data: {
                labels: topCustomerName,
                datasets: [{
                    backgroundColor: barTopColors,
                    data: topCustomerData
                }]
            },
            options: {
                legend: {display: false},
                scales: {
                    y: {
                        display: true,
                        beginAtZero: true
                    }
                }}
        });
    })

</script>
<script src="<c:url value="/static/js/statistical.js"/>" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>

