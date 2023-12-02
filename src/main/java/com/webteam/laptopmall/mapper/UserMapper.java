package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Named("toUserDTO")
    UserDTO toDTO(User entity);

    @Named("toUser")
    @Mapping(target = "cartItems", ignore = true)
    @Mapping(target = "orders", ignore = true)
    User toEntity(UserDTO dto);
}
