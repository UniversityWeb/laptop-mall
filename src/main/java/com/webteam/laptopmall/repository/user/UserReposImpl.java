package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.db.DbCon;
import com.webteam.laptopmall.entity.User;
import com.webteam.laptopmall.query.UserQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
}
