<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laptop Mall | Login</title>
    <link rel="stylesheet" href="<c:url value="/static/css/login.css"/>" type="text/css">
</head>
<body class="center">

<section class="content column center">
    <h1>Login</h1>
    <p>Please enter your username and password to continue.</p>
    <form action="login" method="post" class="login_form column">
        <div class="login_form-input">
            <input type="text" name="username" placeholder=" " required><br>
            <label>Username</label>
        </div>
        <div class="login_form-input">
            <input type="password" name="plainPass" placeholder=" " required><br>
            <label>Password</label>
        </div>

        <a href="register" style="margin-top: 20px;">Register</a>

        <div class="login_form-input">
            <input type="submit" value="Login" class="button_login">
        </div>
    </form>
</section>
</body>
</html>