package com.webteam.laptopmall.realtimechat.service;

import com.webteam.laptopmall.message.ChatMessageDTO;
import com.webteam.laptopmall.realtimechat.ChatWebsocket;

public interface ChatService {

    boolean register(ChatWebsocket chatWebsocket);

    boolean close(ChatWebsocket chatWebsocket);

    void sendMessageToOneUser(ChatMessageDTO message);

    void sendMessageToAllUser(ChatMessageDTO message);

    boolean isOnline(String username);
}
