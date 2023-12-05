package com.webteam.laptopmall.service.chatmessage;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;

import java.util.List;

public interface MessageService {
    ChatMessageDTO save(ChatMessageDTO chatMessage);
    List<ChatMessageDTO> getMessagesForCustomer(String username);
    List<ChatMessageDTO> getMessagesForSalesperson(String sender, String receiver);
}
