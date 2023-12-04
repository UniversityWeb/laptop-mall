package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.entity.ChatMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatMessageMapper {
    ChatMessageMapper INSTANCE = Mappers.getMapper(ChatMessageMapper.class);
    @Named("toChatMessageDTO")
    ChatMessageDTO toDTO(ChatMessage entity);

    @Named("toChatMessage")
    ChatMessage toEntity(ChatMessageDTO dto);
}
