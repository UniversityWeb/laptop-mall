package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.repository.base.BaseRepos;

import java.util.Optional;

public interface UserRepos extends BaseRepos<User, Long> {
    User getUserByUsername(String username);
}
