package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.entity.user.User;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatMessageMapperTest {

    @Test
    void testToDTO() {
        ChatMessage chatMessage = new ChatMessage(1L, "HIHI", ChatMessage.EType.TEXT,
                Timestamp.from(Instant.now()), new User(), new User());
        ChatMessageDTO chatMessageDTO = ChatMessageMapper.INSTANCE.toDTO(chatMessage);

        assertEquals(chatMessage.getId(), chatMessageDTO.getId());
    }

    @Test
    void testToEntity() {
        ChatMessageDTO ChatMessageDTO = new ChatMessageDTO(1L, "HIHI", ChatMessage.EType.TEXT,
                Timestamp.from(Instant.now()), new UserDTO(), new UserDTO());
        ChatMessage ChatMessage = ChatMessageMapper.INSTANCE.toEntity(ChatMessageDTO);

        assertEquals(ChatMessageDTO.getId(), ChatMessage.getId());
    }
}