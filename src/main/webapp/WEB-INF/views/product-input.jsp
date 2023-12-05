<%--
  Created by IntelliJ IDEA.
  User: TRUONG AN
  Date: 12/5/2023
  Time: 3:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/prod-base.css"/>" type="text/css">
</head>
<body>
<jsp:include page="seller-navbar.jsp"></jsp:include>
<form action="register" method="post" class="prod-input__container">
    <div class="prod-basic__info">
        <div  class="register_form column">
            <div class="register_form-input">
                <input type="text" name="prodID" disabled value="${prodID}"><br>
                <label>ID</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="modal" placeholder="" required><br>
                <label>Model</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="price" placeholder="" required value="0"><br>
                <label>Price</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="brand" placeholder="" required><br>
                <label>Brand</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="color" placeholder="white or black..." required><br>
                <label>Color</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="release_year" placeholder="2022,2023..." ><br>
                <label>Release Year</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="stock_qty" placeholder="" required value="0"><br>
                <label>Quantity</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="version" placeholder="" required><br>
                <label>Version</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="discount_percent" placeholder="" value="0" ><br>
                <label>Discount(%)</label>
            </div>
            <div class="register_form-input">
                <textarea name="description" placeholder="" ></textarea><br>
                <label>Description</label>
            </div>
            <div class="group__select-gender" >
                <select id="category" class="register_form-selection" name="category">
                    <option value="LAPTOP">Laptop</option>
                    <option value="MECHANICAL_KEYBOARD">Keyboard</option>
                    <option value="MONITOR">Monitor</option>
                </select>
                <label>Category</label>
            </div>
        </div>
        <input id="imgInput" class="select-file__input" name="images" type="file" multiple accept="image/*">
        <div class="product-info__listimg">
            <ul id="imgList" class="img-list">
                <c:forEach var="imgName" items="${imgList}">
                    <li class="img-item">
                        <div class="img-bottom"><i class="fa-solid fa-trash"></i></div>
                        <img src="app/prod/${imgName}" alt="">
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="prod-category__info">
            <div id="laptopContent" class="register_form column">
            <div class="register_form-input">
                <input type="text" name="anti_glare" placeholder=""  value="0"><br>
                <label>Anti Glare</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="brightness" placeholder=""  value="0"><br>
                <label>Brightness</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cpu_cache" placeholder=""  value="0"><br>
                <label>CPU Cache</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cpu_cores" placeholder=""  value="0"><br>
                <label>CPU Cores</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cpu_max_speed"  placeholder=""  value="0"><br>
                <label>CPU Max Speed</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cpu_name" placeholder=""  ><br>
                <label>CPU Name</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cpu_speed" placeholder="" value="0"><br>
                <label>CPU Speed</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cpu_threads"  placeholder=""  value="0"><br>
                <label>CPU Threads</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="ram_bus_speed"  placeholder=""  value="0"><br>
                <label>RAM Bus Speed</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="graphics_card" placeholder=""  ><br>
                <label>Graphics Card</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="material" placeholder=""  ><br>
                <label>Material</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="operating_system" placeholder=""  ><br>
                <label>Operating System</label>
            </div>
            <div class="register_form-input">
                <input type="submit" value="Save" class="button_register">
            </div>
        </div>

            <div id="keyboardContent" class="register_form column">
            <div class="register_form-input">
                <input type="text" name="battery_type" placeholder="" ><br>
                <label>Battery Type</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="cable_length" placeholder="" ><br>
                <label>Cable Length</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="key_count" placeholder=""  value="0"><br>
                <label>Key Count</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="keycap_material" placeholder=""  value="0"><br>
                <label>Keycap Material</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="keyboard_layout"  placeholder=""  value="0"><br>
                <label>Keyboard Layout</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="switch_type" placeholder=""  ><br>
                <label>Switch Type</label>
            </div>
            <div class="register_form-input">
                <input type="submit" value="Save" class="button_register">
            </div>
        </div>
            <div id="monitorContent" class="register_form column">
                <div class="register_form-input">
                    <input type="text" name="built_in_speakers" placeholder=""  value="0"><br>
                    <label>Built In Speakers</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="brightness" placeholder=""  value="0"><br>
                    <label>Brightness</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="eye_care_technology" placeholder=""  value="0"><br>
                    <label>Eye Care Technology</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="hdr_supported" placeholder=""  value="0"><br>
                    <label>HDR Supported</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="panel_type"  placeholder="IPS,..." ><br>
                    <label>Panel Type</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="power_consumption" placeholder=""  value="0"><br>
                    <label>Power Consumption</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="refresh_rate" placeholder="" value="0"><br>
                    <label>Refresh Rate</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="resolution"  placeholder="1920x1080,..." ><br>
                    <label>Resolution</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="screen_size"  placeholder=""  value="0"><br>
                    <label>Screen Size</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="touch_screen" placeholder=""  value="0"><br>
                    <label>Touch Screen</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="weight" placeholder=""  value="0"><br>
                    <label>Weight</label>
                </div>
                <div class="register_form-input">
                    <input type="submit" value="Save" class="button_register">
                </div>
            </div>

    </div>
</form>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
<script src="<c:url value="/static/js/prod-base.js"/>" async defer ></script>
</body>
</html>
