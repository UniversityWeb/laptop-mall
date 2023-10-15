<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Your Shopping Cart</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="styles/cart.css">
    <link rel="stylesheet" href="styles/check-cart.css">
</head>
<body class="column">
<header class="row center">
    <div class="back_to_shop">
        <a class="back_to_shop row left" href="#">
            <ion-icon name="chevron-back-outline"></ion-icon>
            <span> Tiếp Tục Mua Hàng </span>
        </a>
    </div>
    <h2>LaptopMall</h2>
    <div class="contact_shop right">
        <form action="#" method="post">
            <button class="row center">
                <span> Nhận Hỗ Trợ Ngay </span>
                <ion-icon name="call-outline"></ion-icon>
            </button>
        </form>
    </div>
</header>
<section class="column center">
    <div class="process_payment">
        <ul class="process_list center row">
            <li class="process_step column center">
                <span class="process_step-number center" style="background-color: #2189FF;">1</span>
                <span class="process_step-title center"><strong>Kiểm tra giỏ hàng</strong></span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">2</span>
                <span class="process_step-title center">Thông tin giao hàng</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">3</span>
                <span class="process_step-title center">Chọn thanh toán</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">4</span>
                <span class="process_step-title center">Hoàn thành đặt hàng</span>
            </li>
        </ul>
    </div>
    <div class="content row">
        <div class="content_left">
            <div class="product_list full">
                <div class="your_cart full left row">
                    <h3 class="your_cart-title">Giỏ hàng của bạn</h3>&nbsp;
                    <span class="your_cart-number">(x sản phẩm)</span>
                </div>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:forEach var="item" items="${cart.cartitems}">
                <div class="product_item full row">
                    <table class="product_details full">
                        <tr class="full">
                            <a class="product_img" href="#">
                                <div class="product_img-square center">
                                    <img class="product_img-source" alt="productCode" src="productCode.webp">
                                </div>
                            </a>
                        </tr>
                        <tbody class="row">
                        <tr class="product_details-left column">
                            <td class="product_details-title left">
<%--                                Đường link dẫn đến sản phẩm--%>
                                <a href="#">
                                    <strong>${item.product.model}</strong>
                                </a>
                            </td>
                            <td class="product_details-color left">
                                <span>${item.product.color}</span>
                            </td>
                            <td class="product_details-code left">
                                <span>${item.product.id}</span>
                            </td>
                            <td class="product_details-number left">
                                <form action="#" class="product_details-number-count row" method="post">
                                    <input type="hidden" name="productCode"
                                    value="<c:out value='${item.product.id}'/>">
                                    <button value="Minus Item" class="button-minus">
                                        <ion-icon name="remove-outline"></ion-icon>
                                    </button>
                                    <input type="text" name="productNumber" value="<c:out value='${item.qty}'/>" readonly>
                                    <button value="Add Item" class="button-add">
                                        <ion-icon name="add-outline"></ion-icon>
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <tr class="product_details-right column">
                            <td class="product_details-price right">
                                <span><strong>${item.product.price}</strong></span>
                            </td>
<%--                            Viết hàm tính tiền dựa trên '%' discount--%>
                            <td class="product_details-price-discount right">
                                <span>${item.product.price}</span>
                            </td>
<%--                            Nếu số tiền giảm giá khác 0 thì mới hiện dòng này--%>
                            <td class="product_details-price-text right">
                                <span>Đã giảm giá</span>
                            </td>
                            <td class="product_details-remove right">
                                <form action="#" class="product_details-number-count row" method="post">

                                <input type="hidden" name="productCode"
                                value="<c:out value='${item.product.id}'/>">
                                    <input type="hidden" name="productNumber" value="0">
                                    <button value="Remove Item" class="button-remove">
                                        <ion-icon name="trash-outline"></ion-icon>
                                    </button>
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <hr>
                </c:forEach>
            </div>
        </div>
        <div class="content_right">
            <h3 class="cart_sumary-title">Tổng quan đơn hàng</h3>
            <div class="cart_sumary-policy">
                <label class="cart_sumary-policy-title">Quyền lợi LaptopMall chính hãng</label>
                <div class="cart_sumary-policy-line">
                    <a href="#">
                        <ion-icon class="cart_sumary-icon" name="cube-outline"></ion-icon>
                        Miễn phí giao hàng toàn quốc
                    </a>
                </div>
                <div class="cart_sumary-policy-line">
                    <a href="#">
                        <ion-icon class="cart_sumary-icon" name="wallet-outline"></ion-icon>
                        Đổi trả sản phẩm theo chính sách trong vòng 14 ngày
                    </a>
                </div>
            </div>
            <div class="cart_sumary-support">
                <label class="cart_sumary-support-title"><strong>Hỗ trợ thanh toán:</strong></label>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Hỗ trợ trả góp 0% bằng thẻ tín dụng.
                </div>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Thanh toán khi nhận hàng/thanh toán sau.
                </div>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Thanh toán tại cửa hàng.
                </div>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Thanh toán bằng thẻ quốc tế.
                </div>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Thanh toán bằng ATM/mã QR/Ví điện tử.
                </div>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Thanh toán qua MOMO.
                </div>
                <div class="cart_sumary-support-line left row">
                    <ion-icon name="checkmark-outline"></ion-icon>
                    Mua trước trả sau
                </div>
            </div>
            <div class="sumary_invoice full">
                <div class="sumary_invoice_line full">
<%--                    Tổng tiền đã trừ tiền discount của cart--%>
                    <span class="left"><strong>Tổng giá sau thuế:</strong></span>
                    <span class="right"><strong>10.989.900đ</strong></span>
                </div>
<%--                    Tổng tiền giảm giá của cart--%>
                <div class="sumary_invoice_line full">
                    <span class="left">Tổng tiền giảm giá</span>
                    <span class="right">3.000.000đ</span>
                </div>
<%--                    Tổng price của product trong card --%>
                <div class="sumary_invoice_line full">
                    <span class="left">Tổng tiền trước giảm giá</span>
                    <span class="right">13.989.900đ</span>
                </div>
            </div>
            <hr>
            <form action="#" method="post" class="full center">
                <button class="button_payment">Thanh Toán</button>
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