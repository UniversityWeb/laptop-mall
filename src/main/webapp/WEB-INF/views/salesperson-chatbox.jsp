<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="<c:url value="/static/css/base.css" />">
  <link rel="stylesheet" href="<c:url value="/static/css/chatbox.css" />">
  <link rel="stylesheet" href="<c:url value="/static/css/salesperson-chatbox.css" />">
</head>
<body>

<div class="chat__container">
  <div class="conversations">
    <ul id="conversationListUl">
    </ul>
  </div>

  <div class="msg__pane">
    <div class="chat" id="chat">
    </div>

    <div class="chatbox__group-items">
      <input type="text" id="input-msg" class="input__msg" placeholder="Type your message...">
      <img onclick="sendMsg()" class="chatbox__send" src="<c:url value="/static/images/send.svg"/>" alt=""/>
    </div>
  </div>
</div>

<script type="text/javascript">
  var currentUsername = "${user.username}";
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
    const restUrl = window.location.protocol + "//" + window.location.host + contextPath + "/get-chatted-users" +
            "?username=" + sender;
    console.log("fetchChattedUsers - restUrl: " + restUrl);
    fetch(restUrl)
            .then(response => response.json())
            .then(chattedUsers => {
              clearConversations();
              chattedUsers.forEach(user => {
                addConversationItem(user.username);
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
            "/get-messages-for-salesperson?sender=" + sender + "&receiver=" + receiver;
    console.log("fetchMessages - restUrl: " + restUrl);
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
    const sender = chatMessage.senderUsername;
    const chat = document.getElementById('chat');

    if (chat) {
      const msg = chatMessage.message;
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

</body>
</html>
