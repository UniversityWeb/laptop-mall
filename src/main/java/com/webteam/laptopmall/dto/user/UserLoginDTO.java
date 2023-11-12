package com.webteam.laptopmall.dto.user;

import com.webteam.laptopmall.entity.user.UserLogin;

public class UserLoginDTO {
    private String username;
    private String passHash;
    private UserDTO user;
    private UserLogin.ERole role;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String username, String passHash, UserDTO user, UserLogin.ERole role) {
        this.username = username;
        this.passHash = passHash;
        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserLogin.ERole getRole() {
        return role;
    }

    public void setRole(UserLogin.ERole role) {
        this.role = role;
    }
}
