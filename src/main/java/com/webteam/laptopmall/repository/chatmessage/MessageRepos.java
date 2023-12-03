package com.webteam.laptopmall.repository.chatmessage;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.List;

public interface MessageRepos extends BaseRepos<ChatMessage, Long> {
    List<UserDTO> getChattedUsersByCurrentUser(String curUsername);
    List<ChatMessageDTO> getMessagesForCustomer(String username);
    List<ChatMessageDTO> getMessagesForSalesperson(String sender, String receiver);
}
