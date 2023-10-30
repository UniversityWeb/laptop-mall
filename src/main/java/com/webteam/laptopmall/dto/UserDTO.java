package com.webteam.laptopmall.dto;

import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.customenum.EUserRole;

public class UserDTO {
    private Long id;
    private String address;
    private String email;
    private String fullName;
    private EGender gender;
    private String passHash;
    private String phoneNo;
    private String username;
    private EUserRole role;

    public UserDTO() {
    }

    public UserDTO(Long id, String address, String email, String fullName, EGender gender,
                   String passHash, String phoneNo, String username, EUserRole role) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.passHash = passHash;
        this.phoneNo = phoneNo;
        this.username = username;
        this.role = role;
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

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
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

    public EUserRole getRole() {
        return role;
    }

    public void setRole(EUserRole role) {
        this.role = role;
    }
}
