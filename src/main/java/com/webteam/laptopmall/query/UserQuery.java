package com.webteam.laptopmall.query;

import com.webteam.laptopmall.entity.user.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class UserQuery {
    public TypedQuery<User> buildFindByUsername(EntityManager em, String username) {
        String jpqlStr = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> typedQuery = em.createQuery(jpqlStr, User.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<User.ERole> buildGetRoleByUsername(EntityManager em, String username) {
        String jpqlStr = "SELECT u.role FROM User u WHERE u.username = :username";
        TypedQuery<User.ERole> typedQuery = em.createQuery(jpqlStr, User.ERole.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<User> buildGetByUsername(EntityManager em, String username) {
        String jpqlStr = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> typedQuery = em.createQuery(jpqlStr, User.class);
        typedQuery.setParameter("username", username);
        return typedQuery;
    }

    public TypedQuery<String> buildGetAllCustomerUsernames(EntityManager em) {
        String jpqlStr = "SELECT u.username FROM User u WHERE u.role = :role";
        TypedQuery<String> typedQuery = em.createQuery(jpqlStr, String.class);
        typedQuery.setParameter("role", User.ERole.CUSTOMER);
        return typedQuery;
    }

    public Query buildUpdateWithoutUsernameAndPassword(EntityManager em, User user) {
        String jpqlStr = "UPDATE User u SET u.address = :address, u.email = :email, u.fullName = :fullName," +
                "u.gender = :gender, u.phoneNo = :phoneNo, u.username = :username WHERE u.id = :id";
        Query query = em.createQuery(jpqlStr);
        query.setParameter("address", user.getAddress());
        query.setParameter("email", user.getEmail());
        query.setParameter("fullName", user.getFullName());
        query.setParameter("gender", user.getGender());
        query.setParameter("phoneNo", user.getPhoneNo());
        query.setParameter("username", user.getUsername());
        query.setParameter("id", user.getId());
        return query;
    }

    public Query buildUpdatePassOnly(EntityManager em, Long userId, String newHashedPass) {
        String jpqlStr = "UPDATE User u SET u.passHash = :newHashedPass WHERE u.id = :userId";
        Query query = em.createQuery(jpqlStr);
        query.setParameter("newHashedPass", newHashedPass);
        query.setParameter("userId", userId);
        return query;
    }
}
