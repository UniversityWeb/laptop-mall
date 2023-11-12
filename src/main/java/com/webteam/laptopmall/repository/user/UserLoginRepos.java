package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.entity.user.UserLogin;
import com.webteam.laptopmall.repository.base.BaseRepos;

public interface UserLoginRepos extends BaseRepos<UserLogin, Long> {
    UserLogin update(UserLogin user);

    UserLogin findByUsername(String username);

    UserLogin.ERole getRoleByUsername(String username);
}
