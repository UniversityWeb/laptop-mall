package com.webteam.laptopmall.realtimechat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webteam.laptopmall.message.ChatMessageDTO;
import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.message.ChatMessage;
import com.webteam.laptopmall.realtimechat.service.ChatService;
import com.webteam.laptopmall.realtimechat.service.ChatServiceImpl;
import com.webteam.laptopmall.message.service.MessageService;
import com.webteam.laptopmall.message.service.MessageServiceImpl;
import com.webteam.laptopmall.user.service.UserServiceImpl;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Logger;

@ServerEndpoint("/chat/{senderUsername}/{receiverUsername}")
public class ChatWebsocket {

    private static final Logger log = Logger.getLogger(ChatWebsocket.class.getName());
    private Session session;
    private UserDTO sender;
    private UserDTO receiver;
    private ChatService chatService;
    private UserServiceImpl userService;
    private MessageService messageService;

    public ChatWebsocket() {
        chatService = ChatServiceImpl.getIns();
        userService = new UserServiceImpl();
        messageService = new MessageServiceImpl();
    }

    @OnOpen
    public void onOpen(@PathParam("senderUsername") String senderUsername,
                       @PathParam("receiverUsername") String receiverUsername,
                       Session session) {
        if (!chatService.register(this)) {
            return;
        }
        this.session = session;
        sender = userService.getByUsername(senderUsername);
        receiver = userService.getByUsername(receiverUsername);
        if (sender == null) {
            return;
        }
        if (receiver == null || !chatService.isOnline(receiverUsername)) {
            return;
        }

        String msg = String.format("`%s` join chat.", senderUsername);
        sendAndSaveMessage(msg, ChatMessage.EType.NOTIFICATION);
    }

    @OnClose
    public void onClose(Session curSession) {
        if (!chatService.close(this)) {
            return;
        }
        if (receiver == null || !chatService.isOnline(receiver.getUsername())) {
            return;
        }
        String msg = String.format("`%s` close chat.", sender.getUsername());
        sendAndSaveMessage(msg, ChatMessage.EType.NOTIFICATION);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        sendAndSaveMessage(message, ChatMessage.EType.TEXT);
    }

    private void sendAndSaveMessage(String msg, ChatMessage.EType type) {
        ChatMessageDTO chatMessageDTO = new ChatMessageDTO(msg, type,
                Timestamp.from(Instant.now()), sender, receiver);
        chatService.sendMessageToOneUser(chatMessageDTO);
        messageService.save(chatMessageDTO);
    }

    public void sendMessage(ChatMessageDTO message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(message);

            session.getBasicRemote().sendText(jsonMessage);
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public UserDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }
}
