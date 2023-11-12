package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

public class UserReposImpl extends BaseReposImpl<User, Long> implements UserRepos {
    @Override
    protected Class<User> getClassType() {
        return User.class;
    }
}
