package com.webteam.laptopmall.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {
    private Long id;
    private String address;
    @JsonIgnore
    private String email;
    private String fullName;
    @JsonIgnore
    private EGender gender;
    @JsonIgnore
    private String phoneNo;
    private String username;
    @JsonIgnore
    private String passHash;
    private User.ERole role;
    @JsonIgnore
    private String avatarUrl;

    public UserDTO() {
    }

    public UserDTO(Long id, String address, String email, String fullName, EGender gender, String phoneNo, String username, String passHash, User.ERole role) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.username = username;
        this.passHash = passHash;
        this.role = role;
    }

    public UserDTO(String address, String email, String fullName, EGender gender,
                   String phoneNo, String username, String passHash, User.ERole role) {
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.username = username;
        this.passHash = passHash;
        this.role = role;
    }

    public UserDTO(Long id, String address, String email, String fullName, EGender gender, String phoneNo, String username) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.username = username;
    }

    public UserDTO(String address, String email, String fullName, String phoneNo) {
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public User.ERole getRole() {
        return role;
    }

    public void setRole(User.ERole role) {
        this.role = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
