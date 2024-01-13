<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Customer and Salesperson Accounts</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="container mt-5">
  <h1 class="text-center">Customer and Salesperson Accounts</h1>
  <p class="text-center">(Default password: 123456)</p>

  <button class="btn btn-primary" onclick="backToLogin()">Back to login form</button>

  <div class="row mt-4">
    <div class="col-md-6">
      <h2>Customer Accounts</h2>
      <ul class="list-group">
        <c:forEach var="customerAccount" items="${customerAccounts}">
          <li class="list-group-item">
            <strong>Full Name:</strong> ${customerAccount.fullName}<br>
            <strong>Username:</strong> ${customerAccount.username}<br>
            <strong>Email:</strong> ${customerAccount.email}<br>
            <strong>Role:</strong> ${customerAccount.role}<br>

            <form action="login" method="post">
              <input type="hidden" name="username" value="${customerAccount.username}">
              <input type="hidden" name="plainPass" value="123456">
              <button type="submit" class="btn btn-primary">Login</button>
            </form>
          </li>
        </c:forEach>
      </ul>
    </div>

    <div class="col-md-6">
      <h2>Salesperson Accounts</h2>
      <ul class="list-group">
        <c:forEach var="salespersonAccount" items="${salespersonAccounts}">
          <li class="list-group-item">
            <strong>Full Name:</strong> ${salespersonAccount.fullName}<br>
            <strong>Username:</strong> ${salespersonAccount.username}<br>
            <strong>Email:</strong> ${salespersonAccount.email}<br>
            <strong>Role:</strong> ${salespersonAccount.role}<br>

            <form action="login" method="post">
              <input type="hidden" name="username" value="${salespersonAccount.username}">
              <input type="hidden" name="plainPass" value="123456">
              <button type="submit" class="btn btn-primary">Login</button>
            </form>
          </li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>

<%
  String contextPath = request.getContextPath();
%>

<script>
  function backToLogin() {
    window.location.href = '<%= contextPath %>/login';
  }
</script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
