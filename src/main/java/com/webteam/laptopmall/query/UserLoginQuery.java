package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.user.UserLogin;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserLoginQuery {
    public TypedQuery<UserLogin> buildFindByUsername(EntityManager em, String username) {
        String sqlStr = "SELECT u FROM UserLogin u WHERE u.username = :username";
        TypedQuery<UserLogin> typedQuery = em.createQuery(sqlStr, UserLogin.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<UserLogin.ERole> buildGetRoleByUsername(EntityManager em, String username) {
        String sqlStr = "SELECT u.role FROM UserLogin u WHERE u.username = :username";
        TypedQuery<UserLogin.ERole> typedQuery = em.createQuery(sqlStr, UserLogin.ERole.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }
}
