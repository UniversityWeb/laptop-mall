<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error 404 - Page Not Found</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }

        body{
            background: linear-gradient(to right, #1c1220 40%, #2c1428 60%);
        }

        section{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        section i{
            color: white;
            margin-bottom: 30px;
        }

        section h1{
            color: #fff;
            font-size: 30px;
            text-transform: uppercase;
            font-weight: 800;
            letter-spacing: 2px;
            line-height: 60px;
            margin-bottom: 30px;
        }

        section button{
            color: white;
        }

        section button{
            color: white;
            background-color: #ff6b6b;
            border: none;
            padding: 10px 20px;
            font-size: 18px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        section button:hover{
            background-color: #ff4949;
        }
    </style>
</head>
<body>
    <section>
        <i class="fa-regular fa-compass fa-beat fa-2xl"></i>
        <h1>error 404 - page not found</h1>
        <button onclick="goHome()">Go home</button>
    </section>

    <%
        String contextPath = request.getContextPath();
    %>

    <script>
        function goHome() {
            window.location.href = '<%= contextPath %>/login';
        }
    </script>
</body>
</html>