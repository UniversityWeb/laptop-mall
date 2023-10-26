<%--
  Created by IntelliJ IDEA.
  User: TRUONG AN
  Date: 10/27/2023
  Time: 2:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="asset/styles/base.css" />
    <link rel="stylesheet" href="asset/styles/chatbox.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@700&display=swap"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"/>
</head>
<body>
<div id="chat-box" class="chat_box">
    <div class="chatbox__navbar">
        <img class="logo-chatbox" src="asset/images/logo-light.svg" alt="">
        <img id="close_chat" class="close__chatbox" src="asset/images/btn-close.svg" alt="">
    </div>
    <div class="chatbox__content">
        <div class="chatbox__chat-received">
            <img class="chat__bot-img" src="asset/images/account_icon.svg" alt="">
            <ul class="list__bubble-chat">
                <li class="bubble-chat__item">
                    <p>Hi hiiiiiiiii</p>
                </li>
                <li class="bubble-chat__item">
                    <p>Hi hiiiiiiiiiiiiiiiii</p>
                </li>
                <li class="bubble-chat__item">
                    <p>Hi hiiiiiiiiiiiiiiiiicxjxkbcxjbcjbcjbcsabcshszchbscbcbhbcsch</p>
                </li>
            </ul>
        </div>
        <div class="chatbox__chat-Sent">
            <div class="chat__my-img">A</div>
            <ul class="list__bubble-chat">
                <li class="bubble-chat__item">
                    <p>Hi hiiiiiiiii</p>
                </li>
                <li class="bubble-chat__item">
                    <p>Hi hiiiiiiiiiiiiiiiii</p>
                </li>
            </ul>
        </div>
        <div class="chatbox__chat-received">
            <img class="chat__bot-img" src="asset/images/account_icon.svg" alt="">
            <ul class="list__bubble-chat">
                <li class="bubble-chat__item">
                    <p>Hi hiiiiiiiii</p>
                </li>

            </ul>
        </div>
    </div>
    <div class="chatbox__group-items">
        <input class="chatbox__input" name="" id="" cols="30" rows="10"></textarea>
        <img class="chatbox__send" src="asset/images/send.svg" alt="">
    </div>
</div>
<img id="chat-icon" class="chat_icon" src="asset/images/chat_btn.svg" alt="">
<script src="asset/javascript/chatbox.js"></script>
</body>
</html>
