package com.webteam.laptopmall.repository.userlogin;

import com.webteam.laptopmall.entity.user.UserLogin;
import com.webteam.laptopmall.query.UserLoginQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import java.util.logging.Logger;

public class UserLoginReposImpl extends BaseReposImpl<UserLogin, Long> implements UserLoginRepos {

    private final Logger log = Logger.getLogger(UserLoginReposImpl.class.getName());

    private UserLoginQuery uQuery;

    public UserLoginReposImpl() {
        super();
        uQuery = new UserLoginQuery();
    }

    @Override
    protected Class<UserLogin> getClassType() {
        return UserLogin.class;
    }

    @Override
    public UserLogin update(UserLogin user) {
        return null;
    }

    @Override
    public UserLogin findByUsername(String username) {
        return getSingleResult(em -> uQuery.buildFindByUsername(em, username));
    }

    @Override
    public UserLogin.ERole getRoleByUsername(String username) {
        return getSingleResult(em -> uQuery.buildGetRoleByUsername(em, username));
    }
}
