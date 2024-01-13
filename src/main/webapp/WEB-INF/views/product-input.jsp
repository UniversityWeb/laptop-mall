<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
%>
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
<form action="<%= contextPath %>/save-prod" method="post" name="product" enctype="multipart/form-data" class="prod-input__container">
    <div class="prod-basic__info">
        <div  class="register_form column">
            <input type="hidden" name="id" value="${product.id}">
            <div class="register_form-input">
                <input type="text" name="model"  value="${product.model}" required><br>
                <label>Model</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="price"  required value="${product.price}"><br>
                <label>Price</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="brand"  value="${product.brand}" required><br>
                <label>Brand</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="color" placeholder="white or black..." value="${product.color}" required><br>
                <label>Color</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="releaseYear" placeholder="2022,2023..." value="${product.releaseYear}" ><br>
                <label>Release Year</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="stockQty"  required value="${product.stockQty}"><br>
                <label>Quantity</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="version"  required value="${product.version}"><br>
                <label>Version</label>
            </div>
            <div class="register_form-input">
                <input type="text" name="discountPercent"  value="${product.discountPercent}"><br>
                <label>Discount(%)</label>
            </div>
            <div class="register_form-input">
                <input name="desc" type="text"  value="${product.desc}"><br>
                <label>Description</label>
            </div>
            <div hidden="true" class="group__select-gender" >
                <select class="register_form-selection" name="category" >
                    <c:forEach var="categorie" items="${eCategories}">
                        <c:if test="${categorie == product.category}">
                            <option value="${categorie}" selected><c:out value="${categorie}"></c:out></option>
                        </c:if>
                        <c:if test="${categorie != product.category}">
                            <option value="${categorie}"><c:out value="${categorie}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
                <label>Category</label>
            </div>
        </div>
        <input id="imgInput" class="select-file__input" name="images" type="file" multiple accept="image/*">
    </div>
    <div class="prod-category__info">
        <c:if test="${product.category == 'LAPTOP'}">
            <div id="laptopContent" class="register_form column">
                <div class="register_form-input">
                    <input type="text" name="cpuName"  value="${product.cpuName}" ><br>
                    <label>CPU Name</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="cpuCores"  value="${product.cpuCores}" ><br>
                    <label>CPU Cores</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="cpuThreads"  value="${product.cpuThreads}" ><br>
                    <label>CPU Threads</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="cpuSpeed"  value="${product.cpuSpeed}" ><br>
                    <label>CPU Speed</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="cpuMaxSpeed"  value="${product.cpuMaxSpeed}" ><br>
                    <label>CPU Max Speed</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="cpuCache"  value="${product.cpuCache}" ><br>
                    <label>CPU Cache</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="ramSize"  value="${product.ramSize}" ><br>
                    <label>RAM Size</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="ramType" value="${product.ramType}" >
                        <c:forEach var="eRam" items="${eRams}">
                            <option value="${eRam}"><c:out value="${eRam}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>RAM Type</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="ramBusSpeed"  value="${product.ramBusSpeed}" ><br>
                    <label>RAM Bus Speed</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="ramMaxSupport"  value="${product.ramMaxSupport}" ><br>
                    <label>RAM Max Support</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="romType" value="${product.romType}" >
                        <c:forEach var="eRom" items="${eRoms}">
                            <option value="${eRom}"><c:out value="${eRom}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>ROM Type</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="romSize"  value="${product.romSize}" ><br>
                    <label>ROM Size</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="screenSize"  value="${product.screenSize}" ><br>
                    <label>Screen Size</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="screenResolution"  value="${product.screenResolution}" ><br>
                    <label>Screen Resolution</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="screenRefreshRate"  value="${product.screenRefreshRate}" ><br>
                    <label>Screen Refresh Rate</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="screenTechnology"  value="${product.screenTechnology}" ><br>
                    <label>Screen Technology</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="brightness"  value="${product.brightness}" ><br>
                    <label>Brightness</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="antiGlare" value="${product.antiGlare}" >
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <label>RAM Type</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="graphicsCard"  value="${product.graphicsCard}" ><br>
                    <label>Graphics Card</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="weight"  value="${product.weight}" ><br>
                    <label>Weight</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="material"  value="${product.material}" ><br>
                    <label>Material</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="operatingSystem" value="${product.operatingSystem}" >
                        <c:forEach var="eos" items="${eosList}">
                            <option value="${eos}"><c:out value="${eos}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>Operating System</label>
                </div>
                <div class="register_form-input">
                    <input type="submit" value="Save" class="button_register">
                </div>
            </div>
        </c:if>
        <c:if test="${product.category == 'MECHANICAL_KEYBOARD'}">
            <div id="keyboardContent" class="register_form column">
                <div class="group__select-gender" >
                    <select class="register_form-selection" name="compatibilities" value="${product.compatibilities}" >
                        <c:forEach var="eos" items="${eosList}">
                            <option value="${eos}"><c:out value="${eos}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>Compatibilities</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="connections" value="${product.connections}" >
                        <c:forEach var="econn" items="${eConnections}">
                            <option value="${econn}"><c:out value="${econn}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>Connections</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="cableLength"  value="${product.cableLength}" ><br>
                    <label>Cable Length</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="switchType"  value="${product.switchType}" ><br>
                    <label>Switch Type</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="layout" value="${product.layout}" >
                        <c:forEach var="eLayout" items="${eLayouts}">
                            <option value="${eLayout}"><c:out value="${eLayout}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>Layout</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="keyCount"  value="${product.keyCount}" ><br>
                    <label>Key Count</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="keycapMaterial"  value="${product.keycapMaterial}" ><br>
                    <label>Keycap Material</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="batteryType"  value="${product.batteryType}" ><br>
                    <label>Battery Type</label>
                </div>

                <div class="register_form-input">
                    <input type="submit" value="Save" class="button_register">
                </div>
            </div>
        </c:if>
        <c:if test="${product.category == 'MONITOR'}">
            <div id="monitorContent" class="register_form column">
                <div class="register_form-input">
                    <input type="text" name="screenSize"  value="${product.screenSize}" ><br>
                    <label>Screen Size</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="resolution"  value="${product.resolution}" ><br>
                    <label>Resolution</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="touchScreen" value="${product.touchScreen}" >
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <label>Touch Screen</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="panelType" value="${product.panelType}" >
                        <c:forEach var="ePanel" items="${ePanels}">
                            <option value="${ePanel}"><c:out value="${ePanel}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>Panel Type</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="refreshRate"  value="${product.refreshRate}" ><br>
                    <label>Refresh Rate</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="eyeCareTechnology" value="${product.eyeCareTechnology}" >
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <label>Eye Care Technology</label>
                </div>
                <div class="register_form-input">
                    <input type="text" name="brightness"  value="${product.brightness}" ><br>
                    <label>Brightness</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="hdrSupported" value="${product.hdrSupported}" >
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <label>HDR Supported</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="builtInSpeakers" value="${product.builtInSpeakers}" >
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                    <label>Built-in Speakers</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="powerConsumption"  value="${product.powerConsumption}" ><br>
                    <label>Power Consumption</label>
                </div>

                <div class="register_form-input">
                    <input type="text" name="weight"  value="${product.weight}" ><br>
                    <label>Weight</label>
                </div>

                <div class="group__select-gender" >
                    <select class="register_form-selection" name="connections" value="${product.connections}" >
                        <c:forEach var="econn" items="${eConnections}">
                            <option value="${econn}"><c:out value="${econn}"></c:out></option>
                        </c:forEach>
                    </select>
                    <label>Connections</label>
                </div>
                <div class="register_form-input">
                    <input type="submit" value="Save" class="button_register">
                </div>
            </div>
        </c:if>
    </div>
</form>
<div class="product-info__listimg">
    <ul id="imgList" class="img-list">
        <c:forEach var="imageUrl" items="${product.imageUrls}">
            <li class="img-item">
                <div class="img-bottom"><i class="fa-solid fa-trash"></i></div>
                <img src="<c:url value="${imageUrl}"/>" alt="">
            </li>
        </c:forEach>
    </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
<script src="<c:url value="/static/js/prod-base.js"/>" async defer ></script>
</body>
</html>
