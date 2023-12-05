<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <title>Laptop Mall | Profile</title>
    <link rel="stylesheet" href="<c:url value="/static/css/register.css" />">
</head>
<body class="center">

<jsp:include page="navbar.jsp"></jsp:include>

<%
    String contextPath = request.getContextPath();
%>

<section class="content column center" style="margin-top: 80px">
    <h1>Profile</h1>
    <p id="description">You can update some information.</p>

    <form action="<%= contextPath %>/update-avatar" method="post" onsubmit="return validateAvatarForm()"
          class="register_form column" enctype="multipart/form-data">
        <input type="hidden" name="username" value="${user.username}">

        <div class="register_form-input">
            <label for="avatar">Choose Avatar:</label>
            <input type="file" id="avatar" name="avatarUrl" accept="image/*">
            <div style="display: inline-block; position: relative; overflow: hidden; text-align: center;">
                <img id="preview" src="<c:url value="${user.avatarUrl}" />" alt="Selected Avatar"
                     style="border-radius: 50%;border: 2px solid #ddd;width: 220px; height: 220px;">
            </div>
        </div>

        <div class="register_form-input">
            <input type="submit" value="Submit Avatar" class="button_register">
        </div>
    </form>


    <form action="<%= contextPath %>/user-profile" method="post" class="register_form column">
        <div class="register_form-input" style="margin-top: 30px">
            <input type="hidden" name="id" value="${user.id}">

            <input type="text" name="fullName" value="${user.fullName}" placeholder=" " required><br>
            <label>Full name</label>
        </div>
        <div class="group__select-gender">
            <select class="register_form-selection" name="genderStr">
                <c:forEach items="${genders}" var="gender">
                    <option value="${gender}">${gender.displayName}</option>
                </c:forEach>
            </select>
            <label>Gender</label>
        </div>

        <div class="register_form-input">
            <input type="text" name="phoneNo" value="${user.phoneNo}"  placeholder=" "  maxlength="11" required><br>
            <label>Phone no</label>
        </div>

        <div class="register_form-input">
            <input type="email" name="email" value="${user.email}" placeholder=" " required><br>
            <label>Email</label>
        </div>

        <div class="register_form-input">
            <input type="text" name="address" value="${user.address}" placeholder=" " required><br>
            <label>Address</label>
        </div>

        <div class="register_form-input">
            <input type="text" name="username" value="${user.username}" placeholder=" " required><br>
            <label>Username</label>
        </div>

        <div class="register_form-input">
            <input type="submit" value="Submit basic information" class="button_register">
        </div>
    </form>

    <form action="<%= contextPath %>/update-password" method="post"
          class="register_form column" onsubmit="return validatePassword();" style="margin-top: 30px;">
        <input type="hidden" name="id" value="${user.id}">

        <div class="register_form-input">
            <input type="password" name="oldPlainPass" value="${userPass.oldPlainPass}" placeholder=" " required><br>
            <label>Old password</label>
        </div>

        <div class="register_form-input">
            <input type="password" id="new-plain-pass" name="newPlainPass"
                   value="${userPass.newPlainPass}" placeholder=" " required><br>
            <label>New password</label>
        </div>
        <div class="register_form-input">
            <input type="password" id="retype-plain-pass" name="reTypePlainPass"
                   value="${userPass.reTypePlainPass}" placeholder=" " required><br>
            <label>Re-type password</label>
        </div>

        <div class="register_form-input">
            <input type="submit" value="Submit password" class="button_register">
        </div>
    </form>
</section>
<script type="text/javascript">
    document.getElementById('avatar').addEventListener('change', function (e) {
        const preview = document.getElementById('preview');
        const file = e.target.files[0];

        if (file) {
            const reader = new FileReader();

            reader.onload = function (event) {
                preview.src = event.target.result;
            };

            reader.readAsDataURL(file);
        } else {
            preview.src = '';
        }
    });

    function validatePassword() {
        var newPassword = document.getElementById("new-plain-pass").value;
        var reTypePassword = document.getElementById("retype-plain-pass").value;

        if (newPassword !== reTypePassword) {
            alert("Passwords do not match. Please re-enter.");
            return false;
        }

        return true;
    }

    function validateAvatarForm() {
        var fileInput = document.getElementById('avatar');
        if (fileInput.files.length === 0) {
            alert('Please choose an avatar before submitting.');
            return false;
        }
        return true; // Allow form submissio
    }
</script>
</body>
</html>