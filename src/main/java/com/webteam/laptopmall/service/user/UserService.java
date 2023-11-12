package com.webteam.laptopmall.service.user;

import com.webteam.laptopmall.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO deleteById(Long id);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
}
