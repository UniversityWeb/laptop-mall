package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.customenum.EUserRole;
import com.webteam.laptopmall.entity.User;
import com.webteam.laptopmall.query.UserQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import java.util.logging.Logger;

public class UserReposImpl extends BaseReposImpl<User, Long> implements UserRepos {

    private final Logger log = Logger.getLogger(UserReposImpl.class.getName());

    private UserQuery uQuery;

    public UserReposImpl() {
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
    public EUserRole getRoleByUsername(String username) {
        return getSingleResult(em -> uQuery.buildGetRoleByUsername(em, username));
    }
}
