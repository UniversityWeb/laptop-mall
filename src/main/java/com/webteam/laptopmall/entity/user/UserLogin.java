package com.webteam.laptopmall.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "user_logins")
public class UserLogin {
    public enum ERole {
        SALESPERSON, CUSTOMER
    }

    @Id
    private String username;

    @Column(name = "pass_hash")
    private String passHash;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public UserLogin() {
    }

    public UserLogin(String username, String passHash, User user, ERole role) {
        this.username = username;
        this.passHash = passHash;
        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", passHash='" + passHash + '\'' +
                ", user=" + user +
                ", role=" + role +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
