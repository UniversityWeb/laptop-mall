package com.webteam.laptopmall.repository.login;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.query.UserQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import java.util.logging.Logger;

public class LoginReposImpl extends BaseReposImpl<User, Long> implements LoginRepos {

    private final Logger log = Logger.getLogger(LoginReposImpl.class.getName());

    private UserQuery uQuery;

    public LoginReposImpl() {
        super();
        uQuery = new UserQuery();
    }

    @Override
    protected Class<User> getClassType() {
        return User.class;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return getSingleResult(em -> uQuery.buildFindByUsername(em, username));
    }

    @Override
    public User.ERole getRoleByUsername(String username) {
        return getSingleResult(em -> uQuery.buildGetRoleByUsername(em, username));
    }
}
