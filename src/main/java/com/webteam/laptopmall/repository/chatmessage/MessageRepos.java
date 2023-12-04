package com.webteam.laptopmall.repository.chatmessage;

import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.List;

public interface MessageRepos extends BaseRepos<ChatMessage, Long> {
    List<ChatMessage> getMessagesForCustomer(String username);
    List<ChatMessage> getMessagesForSalesperson(String sender, String receiver);
}
