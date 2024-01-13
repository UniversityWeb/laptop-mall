package com.webteam.laptopmall.message.repos;

import com.webteam.laptopmall.message.ChatMessage;
import com.webteam.laptopmall.infrastructure.repository.BaseReposImpl;
import com.webteam.laptopmall.message.MessageQuery;

import java.util.List;

public class MessageReposImpl extends BaseReposImpl<ChatMessage, Long> implements MessageRepos {

    private MessageQuery mQuery;

    public MessageReposImpl() {
        super();
        mQuery = new MessageQuery();
    }

    @Override
    protected Class<ChatMessage> getClassType() {
        return ChatMessage.class;
    }

    @Override
    public List<ChatMessage> getMessagesForCustomer(String username) {
        return getResultList(em -> mQuery.buildGetMessagesForCustomer(em, username));
    }

    @Override
    public List<ChatMessage> getMessagesForSalesperson(String sender, String receiver) {
        return getResultList(em -> mQuery.buildGetMessagesForSalesperson(em, sender, receiver));
    }
}
