package com.webteam.laptopmall.repository.login;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.repository.base.BaseRepos;

public interface LoginRepos extends BaseRepos<User, Long> {
    User update(User user);

    User findByUsername(String username);

    User.ERole getRoleByUsername(String username);
}
