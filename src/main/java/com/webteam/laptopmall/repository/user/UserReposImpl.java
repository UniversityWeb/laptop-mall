package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.query.UserQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserReposImpl extends BaseReposImpl<User, Long> implements UserRepos {

    private static final Logger log = Logger.getLogger(UserReposImpl.class.getName());
    private UserQuery uQuery;

    public UserReposImpl() {
        uQuery = new UserQuery();
    }

    @Override
    protected Class<User> getClassType() {
        return User.class;
    }

    @Override
    public User getUserByUsername(String username) {
        return getSingleResult(em -> uQuery.buildGetByUsername(em, username));
    }
}
