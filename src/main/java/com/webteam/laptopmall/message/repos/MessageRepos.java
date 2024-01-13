package com.webteam.laptopmall.message.repos;

import com.webteam.laptopmall.message.ChatMessage;
import com.webteam.laptopmall.infrastructure.repository.BaseRepos;

import java.util.List;

public interface MessageRepos extends BaseRepos<ChatMessage, Long> {
    List<ChatMessage> getMessagesForCustomer(String username);
    List<ChatMessage> getMessagesForSalesperson(String sender, String receiver);
}
