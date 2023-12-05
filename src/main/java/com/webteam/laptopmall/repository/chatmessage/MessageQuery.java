package com.webteam.laptopmall.repository.chatmessage;

import com.webteam.laptopmall.entity.ChatMessage;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MessageQuery {
    public TypedQuery<ChatMessage> buildGetMessagesForCustomer(EntityManager em, String username) {
        String jpql = "SELECT cm FROM ChatMessage cm " +
                "WHERE cm.receiver.username = :username OR cm.sender.username = :username " +
                "ORDER BY cm.sendingTime";
        TypedQuery<ChatMessage> typedQuery = em.createQuery(jpql, ChatMessage.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<ChatMessage> buildGetMessagesForSalesperson(EntityManager em, String sender, String receiver) {
        String jpql = "SELECT cm FROM ChatMessage cm " +
                "WHERE (cm.sender.username = :sender AND cm.receiver.username = :receiver) " +
                "   OR (cm.sender.username = :receiver AND cm.receiver.username = :sender) " +
                "ORDER BY cm.sendingTime";
        TypedQuery<ChatMessage> typedQuery = em.createQuery(jpql, ChatMessage.class);
        typedQuery.setParameter("sender", sender);
        typedQuery.setParameter("receiver", receiver);
        return typedQuery;
    }
}
