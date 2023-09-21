package com.webteam.laptopmall.models;

import com.webteam.laptopmall.enums.EGender;

import java.io.Serializable;

public class Customer implements Serializable {
    private Long id;
    private String username;
    private String passHash;
    private String email;
    private String address;
    private String phoneNo;
    private String fullName;
    private EGender gender;

    public Customer(){}

    public Customer(String username, String passHash, String email, String address, String phoneNo, String fullName, EGender gender) {
        this.username = username;
        this.passHash = passHash;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
        this.fullName = fullName;
        this.gender = gender;
    }

    public Customer(Long id, String username, String passHash, String email, String address, String phoneNo, String fullName, EGender gender) {
        this.id = id;
        this.username = username;
        this.passHash = passHash;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
        this.fullName = fullName;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
}
