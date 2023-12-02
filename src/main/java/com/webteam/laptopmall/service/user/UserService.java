package com.webteam.laptopmall.service.user;

import com.webteam.laptopmall.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO update(UserDTO userDTO);
    UserDTO deleteById(Long id);
    UserDTO getById(Long id);
    List<UserDTO> getAll();

    UserDTO getByUsername(String username);
}
