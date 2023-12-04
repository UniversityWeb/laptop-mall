package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.user.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserQuery {
    public TypedQuery<User> buildFindByUsername(EntityManager em, String username) {
        String sqlStr = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> typedQuery = em.createQuery(sqlStr, User.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<User.ERole> buildGetRoleByUsername(EntityManager em, String username) {
        String sqlStr = "SELECT u.role FROM User u WHERE u.username = :username";
        TypedQuery<User.ERole> typedQuery = em.createQuery(sqlStr, User.ERole.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<User> buildGetByUsername(EntityManager em, String username) {
        String sqlStr = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> typedQuery = em.createQuery(sqlStr, User.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<String> buildGetAllCustomerUsernames(EntityManager em) {
        String sqlStr = "SELECT u.username FROM User u WHERE u.role = :role";
        TypedQuery<String> typedQuery = em.createQuery(sqlStr, String.class);
        typedQuery.setParameter("role", User.ERole.CUSTOMER);
        return typedQuery;
    }
}
