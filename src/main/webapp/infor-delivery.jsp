<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/22/2023
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="styles/cart.css">
    <link rel="stylesheet" href="styles/infor-delivery.css">
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
                <span class="process_step-number center"><ion-icon name="checkmark-outline"></ion-icon></span>
                <span class="process_step-title center">Kiểm tra giỏ hàng</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center"style="background-color: #2189FF;">2</span>
                <span class="process_step-title center"><strong>Thông tin giao hàng</strong></span>
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
            <form action="" method="post" class="information_deliver">
                <h1> Payment: </h1>
                <input class="information_deliver-text" type="email" type="text" placeholder=" ">
                <p class="information_deliver-label-text"> Email* </p>
                <h1> Delivery Information Details: </h1>
                <div class="information_deliver-method row">
                    <div class="information_deliver-input row left">
                        <input type="radio" name="methodDelivery">
                        <p> Home Delivery </p>
                    </div>
                    <div class="information_deliver-input row left">
                        <input type="radio" name="methodDelivery">
                        <p> Receive at Location </p>
                    </div>
                </div>
                <input class="information_deliver-text" type="text" placeholder=" ">
                <p class="information_deliver-label-text"> Full Name* </p>
                <div class="information_deliver-line row">
                    <div class="information_deliver-input column">
                        <input class="information_deliver-text" type="tel" placeholder=" ">
                        <p class="information_deliver-label-text"> Contact Number (Ordered)* </p>
                    </div>
                    <div class="information_deliver-input column">
                        <input class="information_deliver-text" type="tel" placeholder=" ">
                        <p class="information_deliver-label-text"> Contact Number (Recipient) </p>
                    </div>
                </div>
                <input class="information_deliver-text" placeholder=" " style="width: 700px;">
                <p class="information_deliver-label-text" style="width: 710px;"> Address* </p>
                <p>Notes upon receiving</p>
                <textarea class="note"></textarea>
            </form>
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
                    <span class="left"><strong>Tổng giá sau thuế:</strong></span>
                    <span class="right"><strong>10.989.900đ</strong></span>
                </div>
                <div class="sumary_invoice_line full">
                    <span class="left">Tổng tiền giảm giá</span>
                    <span class="right">3.000.000đ</span>
                </div>
                <div class="sumary_invoice_line full">
                    <span class="left">Tổng tiền trước giảm giá</span>
                    <span class="right">13.989.900đ</span>
                </div>
            </div>
            <hr>
            <form action="#" method="post" class="full center">
                <button class="button_payment">Thanh Toán</button>
            </form>

            <form action="#" method="post" class="full center">
                <button class="button_return">Trở Về</button>
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