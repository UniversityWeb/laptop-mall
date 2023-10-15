<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0">
    <link rel="stylesheet" href="styles/cart.css">
    <link rel="stylesheet" href="styles/method-delivery.css">
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
                <span class="process_step-number center"><ion-icon name="checkmark-outline"></ion-icon></span>
                <span class="process_step-title center">Thông tin giao hàng</span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center" style="background-color: #2189FF;">3</span>
                <span class="process_step-title center"><strong>Chọn thanh toán</strong></span>
            </li>
            <li class="process_step column center">
                <span class="process_step-number center">4</span>
                <span class="process_step-title center">Hoàn thành đặt hàng</span>
            </li>
        </ul>
    </div>
    <div class="content row">
        <div class="content_left">
            <h1>Delivery Information Details:</h1>
            <div class="information_delivery">
                <label>Full Name</label>
                <p>ABC</p>
                <label>Address</label>
                <p>EDF</p>
                <label>Phone Number (Ordered)</label>
                <p>GHI</p>
                <label>Phone Number (Recipient)</label>
                <p>XYZ</p>
            </div>
            <hr>
            <h1>Payment Method:</h1>
            <div class="payment_method row" onclick="showPayment('cash_payment')">
                <p>Cash Payment</p>
                <ion-icon name="chevron-down-outline"></ion-icon>
            </div>
            <div class="cash_payment payment_method-content">
                <input type="checkbox" class="check_box_policy"> Tôi đồng ý các chính sách và điều khoản
            </div>
            <div class="payment_method row" onclick="showPayment('momo_payment')">
                <p>MOMO Payment</p>
                <ion-icon name="chevron-down-outline"></ion-icon>
            </div>
            <div class="momo_payment payment_method-content">
                <img src="QR.png">
            </div>
        </div>
        <div class="content_right">
            <h1>Order Summary</h1>
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
                            <a href="product_details-link">
                                <strong>Galaxy Tab S7 FE LTE</strong>
                            </a>
                        </td>
                        <td class="product_details-color left">
                            <span>Đen phong cách</span>
                        </td>
                        <td class="product_details-code left">
                            <span>SM-T735NZKAXXV</span>
                        </td>
                    </tr>
                    <tr class="product_details-right column">
                        <td class="product_details-price right">
                            <span><strong>10.989.800đ</strong></span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr>
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
                            <a href="product_details-link">
                                <strong>Galaxy Tab S7 FE LTE</strong>
                            </a>
                        </td>
                        <td class="product_details-color left">
                            <span>Đen phong cách</span>
                        </td>
                        <td class="product_details-code left">
                            <span>SM-T735NZKAXXV</span>
                        </td>
                    </tr>
                    <tr class="product_details-right column">
                        <td class="product_details-price right">
                            <span><strong>10.989.800đ</strong></span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr>
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
<script src="scripts/method-delivery.js" async defer></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>