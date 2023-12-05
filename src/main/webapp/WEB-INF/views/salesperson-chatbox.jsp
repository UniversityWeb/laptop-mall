<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="<c:url value="/static/images/logo_short.svg"/>" rel="icon"/>
  <link rel="stylesheet" href="<c:url value="/static/css/base.css" />">
  <link rel="stylesheet" href="<c:url value="/static/css/chatbox.css" />">
  <link rel="stylesheet" href="<c:url value="/static/css/salesperson-chatbox.css" />">
</head>
<body>

<jsp:include page="seller-navbar.jsp"></jsp:include>

<div class="chat__container">
  <div class="conversations">
    <ul id="conversationListUl">
      <li class="sender">
        <div class="sender_avt" >
          <img src="<c:url value="/static/images/account_icon.svg"/>" alt="">
          <div class="pop_onl">
          </div>
        </div>
        <span class="sender_name">Nguyenn Van an</span>
      </li>
    </ul>
  </div>

  <div class="msg__pane">
    <div class="chat" id="chat">
    </div>
    <div class="notify-chat">
      <i id="iconChatAction" class="fa-duotone fa-ellipsis fa-beat"></i>
    </div>

    <div class="chatbox__group-items">
      <input type="text" id="input-msg" class="chatbox__input" placeholder="Type your message...">
      <i class="fa-solid fa-paper-plane chatbox__send" onclick="sendMsg()"></i>
    </div>
  </div>
</div>

<script type="text/javascript">
  var currentUsername = '<%= request.getSession().getAttribute("username") %>';
  var curChattingUsername = null;
  var ws = getWebsocket(curChattingUsername);

  function getWebsocket(receiver) {
    let wsUrl;

    if (window.location.protocol === 'http:') {
      wsUrl = 'ws://';
    } else {
      wsUrl = 'wss://';
    }
    const contextPath = '<%= request.getContextPath() %>';
    return new WebSocket(wsUrl + window.location.host + contextPath +
            '/chat/' + currentUsername + '/' + receiver);
  }

  ws.onmessage = function(event) {
    const chatMessage = JSON.parse(event.data);
    addMessage(chatMessage)
  };

  function fetchChattedUsers(sender) {
    const contextPath = '<%= request.getContextPath() %>';
    const restUrl = window.location.protocol + "//" + window.location.host + contextPath +
            "/api/salesperson/get-customers";
    fetch(restUrl)
            .then(response => response.json())
            .then(customerUsernames => {
              clearConversations();
              customerUsernames.forEach(username => {
                addConversationItem(username);
              });
            })
            .catch(error => console.error('Error fetching chatted users:', error));
  }

  function loadMessages(receiver) {
    if (curChattingUsername === receiver) {
      return;
    }
    curChattingUsername = receiver;
    ws = getWebsocket(receiver);
    fetchMessagesForSalesperson(currentUsername, receiver);
  }

  function fetchMessagesForSalesperson(sender, receiver) {
    const contextPath = '<%= request.getContextPath() %>';
    const restUrl = window.location.protocol + "//" + window.location.host + contextPath +
            "/api/salesperson/get-messages-for-salesperson?sender=" + sender + "&receiver=" + receiver;
    fetch(restUrl)
            .then(response => response.json())
            .then(chatMessages => {
              clearMsgs();
              chatMessages.forEach(cm => {
                addMessage(cm);
              });
            })
            .catch(error => console.error('Error fetching messages:', error));
  }

  function clearMsgs() {
    const chat = document.getElementById('chat');
    if (chat) {
      chat.innerHTML = '';
    } else {
      console.error("Element 'chat' not found.");
    }
  }

  function addMessage(chatMessage) {
    const sender = chatMessage.sender.username;
    const chat = document.getElementById('chat');

    if (chat) {
      const msg = chatMessage.msg;
      const isCurrentUser = sender === currentUsername;
      const senderColor = isCurrentUser ? 'green' : 'red';
      const formattedSender = '<span style="color: ' + senderColor + ';">[' + sender + ']</span>';
      const formattedMessage = formattedSender + ': ' + msg + '<br/>';
      chat.innerHTML += formattedMessage;
    } else {
      console.error("Element 'chat' not found.");
    }
  }

  function sendMsg() {
    const inputMsg = document.getElementById("input-msg");
    const msgStr = inputMsg.value.trim();

    if(msgStr) {
      addTextToChatbox(msgStr, true, currentUsername);
      ws.send(msgStr);
      inputMsg.value="";
    }
  }

  function addTextToChatbox(msg, isSender, sender) {
    const chat = document.getElementById('chat');

    if (chat) {
      const senderColor = isSender ? 'green' : 'red';
      <%--const formattedSender =`<li class="sender">--%>
      <%--  <div class="sender_avt" >--%>
      <%--    <img src="<c:url value="/static/images/account_icon.svg"/>" alt="">--%>
      <%--    <div class="pop_onl" style="color: ' + ${senderColor} + ';">--%>
      <%--    </div>  --%>
      <%--  </div>--%>
      <%--  <span class="sender_name">${sender}</span>--%>
      <%--</li>--%>
      <%--`--%>
      const formattedSender = '<span style="color: ' + senderColor + ';">[' + sender + ']</span>';
      const formattedMessage = formattedSender + ': ' + msg + '<br/>';
      chat.innerHTML += formattedMessage;
    } else {
      console.error("Element 'chat' not found.");
    }
  }

  function clearConversations() {
    const conversationListUl = document.getElementById('conversationListUl');
    conversationListUl.innerHTML = '';
  }

  function addConversationItem(receiver) {
    console.log("OnClick addConversationItem")
    const conversationListUl = document.getElementById('conversationListUl');

    if (conversationListUl) {
      const li = document.createElement('li');
      li.textContent = receiver;
      li.onclick = function () {
        loadMessages(receiver);
      };
      conversationListUl.appendChild(li);
    } else {
      console.error("Element 'conversationListUl' not found.");
    }
  }

  document.getElementById("input-msg").addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
      sendMsg();
    }
  });

  document.addEventListener('DOMContentLoaded', function() {
    fetchChattedUsers(currentUsername);
  });
</script>
<script type="text/javascript" src="<c:url value="/static/js/chatbox.js" />" charset="utf-8"></script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
</body>
</html>
