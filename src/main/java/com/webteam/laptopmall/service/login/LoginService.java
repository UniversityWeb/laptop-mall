package com.webteam.laptopmall.service.login;


import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;

public interface LoginService {
    boolean login(String username, String plainPass);

    String hashPass(String plainPass);

    UserDTO register(UserDTO UserDTO);

    User.ERole getRoleByUsername(String username);
}
