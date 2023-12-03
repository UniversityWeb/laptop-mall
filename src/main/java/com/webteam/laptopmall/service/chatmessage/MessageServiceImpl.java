package com.webteam.laptopmall.service.chatmessage;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.mapper.ChatMessageMapper;
import com.webteam.laptopmall.repository.chatmessage.MessageRepos;
import com.webteam.laptopmall.repository.chatmessage.MessageReposImpl;

import java.util.List;

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
    public List<UserDTO> getChattedUsersByCurrentUser(String curUsername) {
        return mRepos.getChattedUsersByCurrentUser(curUsername);
    }

    @Override
    public List<ChatMessageDTO> getMessagesForCustomer(String username) {
        return mRepos.getMessagesForCustomer(username);
    }

    @Override
    public List<ChatMessageDTO> getMessagesForSalesperson(String sender, String receiver) {
        return mRepos.getMessagesForSalesperson(sender, receiver);
    }
}
