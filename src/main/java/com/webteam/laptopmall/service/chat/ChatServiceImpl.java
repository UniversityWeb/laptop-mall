package com.webteam.laptopmall.service.chat;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.websocket.ChatWebsocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServiceImpl implements ChatService {
    private static ChatService chatService = null;
    protected static final Set<ChatWebsocket> chatWebsockets = new CopyOnWriteArraySet<>();

    private ChatServiceImpl() {
    }

    public synchronized static ChatService getIns() {
        if (chatService == null) {
            chatService = new ChatServiceImpl();
        }
        return chatService;
    }

    @Override
    public boolean register(ChatWebsocket chatWebsocket) {
        return chatWebsockets.add(chatWebsocket);
    }

    @Override
    public boolean close(ChatWebsocket chatWebsocket) {
        return chatWebsockets
                .removeIf(cw -> cw.getSession().equals(chatWebsocket.getSession()));
    }

    @Override
    public void sendMessageToOneUser(ChatMessageDTO message) {
        String targetUser = message.getReceiver().getUsername();
        for (ChatWebsocket chatWebsocket : chatWebsockets) {
            UserDTO sender = chatWebsocket.getSender();
            if (sender.getUsername().equals(targetUser)) {
                chatWebsocket.sendMessage(message);
                return;
            }
        }
    }

    @Override
    public void sendMessageToAllUser(ChatMessageDTO message) {
        chatWebsockets.forEach(cw -> cw.sendMessage(message));
    }

    @Override
    public boolean isOnline(String username) {
        for (ChatWebsocket chatWebsocket : chatWebsockets) {
            if (chatWebsocket.getSender().getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
