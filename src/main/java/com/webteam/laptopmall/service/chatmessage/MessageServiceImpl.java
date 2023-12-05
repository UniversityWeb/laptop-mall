package com.webteam.laptopmall.service.chatmessage;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.mapper.ChatMessageMapper;
import com.webteam.laptopmall.repository.chatmessage.MessageRepos;
import com.webteam.laptopmall.repository.chatmessage.MessageReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class MessageServiceImpl implements MessageService {

    private MessageRepos mRepos;
    private ChatMessageMapper cmMapper;

    public MessageServiceImpl() {
        mRepos = new MessageReposImpl();
        cmMapper = ChatMessageMapper.INSTANCE;
    }

    @Override
    public ChatMessageDTO save(ChatMessageDTO chatMessage) {
        ChatMessage cm = cmMapper.toEntity(chatMessage);
        ChatMessage savedChatMessage = mRepos.save(cm);
        return cmMapper.toDTO(savedChatMessage);
    }

    @Override
    public List<ChatMessageDTO> getMessagesForCustomer(String username) {
        List<ChatMessage> msgs = mRepos.getMessagesForCustomer(username);
        return msgs.stream()
                .map(cmMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessageDTO> getMessagesForSalesperson(String sender, String receiver) {
        List<ChatMessage> msgs = mRepos.getMessagesForSalesperson(sender, receiver);
        return msgs.stream()
                .map(cmMapper::toDTO)
                .collect(Collectors.toList());
    }
}
