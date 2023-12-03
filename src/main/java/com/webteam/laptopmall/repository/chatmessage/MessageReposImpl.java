package com.webteam.laptopmall.repository.chatmessage;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import java.util.List;

public class MessageReposImpl extends BaseReposImpl<ChatMessage, Long> implements MessageRepos {

    @Override
    protected Class<ChatMessage> getClassType() {
        return ChatMessage.class;
    }

    @Override
    public List<UserDTO> getChattedUsersByCurrentUser(String curUsername) {
        return null;
    }

    @Override
    public List<ChatMessageDTO> getMessagesForCustomer(String username) {
        return null;
    }

    @Override
    public List<ChatMessageDTO> getMessagesForSalesperson(String sender, String receiver) {
        return null;
    }
}
