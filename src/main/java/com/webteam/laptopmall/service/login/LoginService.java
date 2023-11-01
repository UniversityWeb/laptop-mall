package com.webteam.laptopmall.service.login;

import com.webteam.laptopmall.customenum.EUserRole;
import com.webteam.laptopmall.dto.UserDTO;

public interface LoginService {
    boolean login(String username, String plainPass);

    String hashPass(String plainPass);

    UserDTO register(UserDTO userDTO);

    EUserRole getRoleByUsername(String username);
}
