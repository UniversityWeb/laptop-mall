package com.webteam.laptopmall.dto.user;

import com.webteam.laptopmall.customenum.EGender;

public class UserDTO {
    private Long id;
    private String address;
    private String email;
    private String fullName;
    private EGender gender;
    private String phoneNo;

    public UserDTO() {
    }

    public UserDTO(Long id, String address, String email,
                   String fullName, EGender gender, String phoneNo) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }

    public UserDTO(String address, String email, String fullName, EGender gender, String phoneNo) {
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
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
}
