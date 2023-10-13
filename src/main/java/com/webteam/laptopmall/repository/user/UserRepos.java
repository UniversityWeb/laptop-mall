package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.entity.User;
import com.webteam.laptopmall.repository.base.BaseRepos;

public interface UserRepos extends BaseRepos<User, Long> {
    User update(User user);
}
