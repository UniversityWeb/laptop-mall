package com.webteam.laptopmall.user.service;

import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.auth.PassUpdateForm;

import java.util.List;

public interface UserService {
    boolean login(String username, String plainPass);
    UserDTO register(UserDTO UserDTO);
    UserDTO deleteById(Long id);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
    UserDTO getByUsername(String username);
    List<String> getAllCustomerUsernames();
    int updateWithoutPassword(UserDTO userDTO);
    User.ERole getRoleByUsername(String username);
    boolean isValid(PassUpdateForm passUpdateForm);
    int updatePassOnly(Long userId, String newHashedPass);
    List<UserDTO> getUsersByRole(User.ERole role);
}
