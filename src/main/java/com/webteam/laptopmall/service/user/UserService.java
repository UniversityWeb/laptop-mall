package com.webteam.laptopmall.service.user;

import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.form.PassUpdateForm;

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
    boolean isValid(Long id, PassUpdateForm passUpdateForm);
    int updatePassOnly(Long userId, String newHashedPass);
}
