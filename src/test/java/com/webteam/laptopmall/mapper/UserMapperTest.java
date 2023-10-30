package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.customenum.EUserRole;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    @Test
    void testToDTO() {
        User user = new User(1L, "Address", "EmailAsn@gmail.com", "Full Name", EGender.FEMALE, "asdfasdf", "09128381238", "vanlongnek", EUserRole.SALESPERSON);
        UserDTO userDTO = UserMapper.INSTANCE.toDTO(user);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getAddress(), userDTO.getAddress());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getFullName(), userDTO.getFullName());
        assertEquals(user.getGender(), userDTO.getGender());
        assertEquals(user.getPassHash(), userDTO.getPassHash());
        assertEquals(user.getPhoneNo(), userDTO.getPhoneNo());
        assertEquals(user.getUsername(), userDTO.getUsername());
    }

    @Test
    void testToEntity() {
        UserDTO userDTO = new UserDTO(1L, "Address", "EmailAsn@gmail.com", "Full Name",
                EGender.FEMALE, "asdfasdf", "09128381238", "vanlongnek", EUserRole.CUSTOMER);
        User user = UserMapper.INSTANCE.toEntity(userDTO);

        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getAddress(), user.getAddress());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getFullName(), user.getFullName());
        assertEquals(userDTO.getGender(), user.getGender());
        assertEquals(userDTO.getPassHash(), user.getPassHash());
        assertEquals(userDTO.getPhoneNo(), user.getPhoneNo());
        assertEquals(userDTO.getUsername(), user.getUsername());
    }
}