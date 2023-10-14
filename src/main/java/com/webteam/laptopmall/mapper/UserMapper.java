package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Named("toUserDTO")
    UserDTO toDTO(User entity);

    @Named("toUser")
    User toEntity(UserDTO dto);
}
