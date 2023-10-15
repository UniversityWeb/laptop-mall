package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.db.DbCon;
import com.webteam.laptopmall.entity.User;
import com.webteam.laptopmall.repository.base.BaseReposImpl;

import javax.persistence.EntityManagerFactory;

public class UserReposImpl extends BaseReposImpl<User, Long> implements UserRepos {

    private EntityManagerFactory emFactory;

    public UserReposImpl() {
        emFactory = DbCon.getIns().getEmf();
    }

    @Override
    protected Class<User> getClassType() {
        return User.class;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
