package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserQuery {
    public TypedQuery<User> buildFindByUsername(EntityManager em, String username) {
        String sqlStr = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> typedQuery = em.createQuery(sqlStr, User.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }
}
