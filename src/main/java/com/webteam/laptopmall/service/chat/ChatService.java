package com.webteam.laptopmall.service.chat;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.websocket.ChatWebsocket;

public interface ChatService {

    boolean register(ChatWebsocket chatWebsocket);

    boolean close(ChatWebsocket chatWebsocket);

    void sendMessageToOneUser(ChatMessageDTO message);

    void sendMessageToAllUser(ChatMessageDTO message);

    boolean isOnline(String username);
}
