<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Laptop Mall | Register</title>
    <link rel="stylesheet" href="<c:url value="/static/css/register.css" />">
</head>
<body class="center">
<section class="content column center">
    <h1>Register</h1>
    <p id="description">Please enter some information to continue.</p>
    <form action="register" method="post" class="register_form column">
        <div class="register_form-input">
            <input type="text" name="fullName" placeholder=" " required><br>
            <label>Full name</label>
        </div>
        <div class="group__select-gender" >
            <select class="register_form-selection" name="genderStr">
              <c:forEach items="${genders}" var="gender">
                        <option value="${gender}">${gender.displayName}</option>
              </c:forEach>
            </select>
            <label>Gender</label>
        </div>


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