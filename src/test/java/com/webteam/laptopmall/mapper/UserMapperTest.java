package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    @Test
    void testToDTO() {
        User user = new User(1L, "Address", "EmailAsn@gmail.com",
                "Full Name", EGender.FEMALE, "09128381238", "sampleUsername",
                "samplePassword", User.ERole.CUSTOMER);
        UserDTO userDTO = UserMapper.INSTANCE.toDTO(user);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getAddress(), userDTO.getAddress());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getFullName(), userDTO.getFullName());
        assertEquals(user.getGender(), userDTO.getGender());
        assertEquals(user.getPhoneNo(), userDTO.getPhoneNo());
        assertEquals(user.getUsername(), userDTO.getUsername());
        assertEquals(user.getPassHash(), userDTO.getPassHash());
        assertEquals(user.getRole(), userDTO.getRole());
    }

    @Test
    void testToEntity() {
        UserDTO userDTO = new UserDTO(1L, "Address", "EmailAsn@gmail.com",
                "Full Name", EGender.FEMALE, "09128381238", "sampleUsername",
                "samplePassword", User.ERole.CUSTOMER);
        User user = UserMapper.INSTANCE.toEntity(userDTO);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getAddress(), userDTO.getAddress());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getFullName(), userDTO.getFullName());
        assertEquals(user.getGender(), userDTO.getGender());
        assertEquals(user.getPhoneNo(), userDTO.getPhoneNo());
        assertEquals(user.getUsername(), userDTO.getUsername());
        assertEquals(user.getPassHash(), userDTO.getPassHash());
        assertEquals(user.getRole(), userDTO.getRole());
    }
}