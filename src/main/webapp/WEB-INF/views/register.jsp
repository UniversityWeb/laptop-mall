<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Laptop Mall | Register</title>
    <link rel="stylesheet" href="<c:url value="/static/css/register.css" />" type="text/css"/>
</head>
<body class="center">
    <section class="content column center">
        <h1>Register</h1>
        <p>Please enter some information to continue.</p>
        <form action="register" method="post" class="login_form column">
            <div class="register_form-input">
                <input type="text" name="fullName" placeholder=" " required><br>
                <label>Full name</label>
            </div>

            <label>Gender</label>
            <select name="genderStr">
                <c:forEach items="${genders}" var="gender">
                    <option value="${gender}">${gender.displayName}</option>
                </c:forEach>
            </select><br>

            <div class="register_form-input">
                <input type="text" name="phoneNo" placeholder=" " required><br>
                <label>Phone no</label>
            </div>

            <div class="register_form-input">
                <input type="email" name="email" placeholder=" " required><br>
                <label>Email</label>
            </div>

            <div class="register_form-input">
                <input type="text" name="address" placeholder=" " required><br>
                <label>Address</label>
            </div>

            <div class="register_form-input">
                <input type="text" name="username" placeholder=" " required><br>
                <label>Username</label>
            </div>

            <div class="register_form-input">
                <input type="password" name="plainPass" placeholder=" " required><br>
                <label>Password</label>
            </div>

            <div class="register_form-input">
                <input type="submit" value="Register" class="button_register">
            </div>
        </form>
    </section>
</body>
</html>