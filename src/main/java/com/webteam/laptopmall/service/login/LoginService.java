package com.webteam.laptopmall.service.login;

import com.webteam.laptopmall.dto.user.UserLoginDTO;
import com.webteam.laptopmall.entity.user.UserLogin;

public interface LoginService {
    boolean login(String username, String plainPass);

    String hashPass(String plainPass);

    UserLoginDTO register(UserLoginDTO userLoginDTO);

    UserLogin.ERole getRoleByUsername(String username);
}
