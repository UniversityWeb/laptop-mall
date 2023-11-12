package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.dto.user.UserLoginDTO;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.entity.user.UserLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginMapperTest {
    @Test
     void testToUserLoginDTO() {
        // Setup
        UserLogin userLogin = userLoginBuilder();

        // Action
        UserLoginDTO userLoginDTO = UserLoginMapper.INSTANCE.toDTO(userLogin);

        // Assert
        assertEquals(userLogin.getUsername(), userLoginDTO.getUsername());
        assertEquals(userLogin.getPassHash(), userLoginDTO.getPassHash());
        assertEquals(userLogin.getUser().getId(), userLoginDTO.getUser().getId());
        assertEquals(userLogin.getRole(), userLoginDTO.getRole());
    }

    private UserLogin userLoginBuilder() {
        return new UserLogin("sampleUsername",
                "samplePassword", new User(), UserLogin.ERole.CUSTOMER);
    }

    @Test
    void testToUserLoginEntity() {
        // Setup
        UserLoginDTO userLoginDTO = userLoginDTOBuilder();

        // Action
        UserLogin userLogin = UserLoginMapper.INSTANCE.toEntity(userLoginDTO);

        // Assert
        assertEquals(userLoginDTO.getUsername(), userLogin.getUsername());
        assertEquals(userLoginDTO.getPassHash(), userLogin.getPassHash());
        assertEquals(userLoginDTO.getUser().getId(), userLogin.getUser().getId());
        assertEquals(userLoginDTO.getRole(), userLogin.getRole());
    }

    private UserLoginDTO userLoginDTOBuilder() {
        return new UserLoginDTO("sampleUsername",
                "samplePassword", new UserDTO(), UserLogin.ERole.CUSTOMER);
    }
}