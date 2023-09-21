package com.webteam.laptopmall.models;

import java.io.Serializable;

public class Admin implements Serializable {
    private Long id;
    private String email;
    private String passHash;
    private String fullName;

    public Admin(){}
    public Admin(String email, String passHash, String fullName){
        this.email = email;
        this.passHash = passHash;
        this.fullName = fullName;
    }

    public Admin(Long id, String email, String passHash, String fullName) {
        this.id = id;
        this.email = email;
        this.passHash = passHash;
        this.fullName = fullName;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getFullName() {
        return fullName;
    }
}
