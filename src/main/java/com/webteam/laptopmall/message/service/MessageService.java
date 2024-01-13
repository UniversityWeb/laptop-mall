package com.webteam.laptopmall.message.service;

import com.webteam.laptopmall.message.ChatMessageDTO;

import java.util.List;

public interface MessageService {
    ChatMessageDTO save(ChatMessageDTO chatMessage);
    List<ChatMessageDTO> getMessagesForCustomer(String username);
    List<ChatMessageDTO> getMessagesForSalesperson(String sender, String receiver);
}
