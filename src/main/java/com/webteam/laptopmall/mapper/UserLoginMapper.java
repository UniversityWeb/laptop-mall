package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.user.UserLoginDTO;
import com.webteam.laptopmall.entity.user.UserLogin;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserLoginMapper {
    UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);

    @Named("toUserLoginDTO")
    UserLoginDTO toDTO(UserLogin entity);

    @Named("toUserLogin")
    UserLogin toEntity(UserLoginDTO dto);
}
