<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Laptop Mall | Login</title>
    <link rel="stylesheet" href="<c:url value="/static/css/login.css"/>" type="text/css">
</head>
<body class="center">

<%
    String contextPath = request.getContextPath();
%>

<section class="content column center">
    <h1>Login</h1>
    <p>Please enter your username and password to continue.</p>
    <form action="<%= contextPath %>/login" method="post" class="login_form column">
        <div class="login_form-input">
            <input type="text" name="username" placeholder=" " required><br>
            <label>Username</label>
        </div>
        <div class="login_form-input">
            <input type="password" name="plainPass" placeholder=" " required><br>
            <label>Password</label>
        </div>

        <a href="<%= contextPath %>/register" style="margin-top: 20px;">Register</a>
        <a href="<%= contextPath %>/get-accounts">Test Account</a>

        <div class="login_form-input">
            <input type="submit" value="Login" class="button_login">
        </div>
    </form>
</section>
</body>
</html>