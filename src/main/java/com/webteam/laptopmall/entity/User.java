package com.webteam.laptopmall.entity;

import com.webteam.laptopmall.customenum.EGender;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.ORDINAL)
    private EGender gender;

    @Column(name = "pass_hash")
    private String passHash;

    @Column(name = "phone_no")
    private String phoneNo;

    private String username;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public User() {
    }

    public User(Long id, String address, String email, String fullName,
                EGender gender, String passHash, String phoneNo, String username) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.passHash = passHash;
        this.phoneNo = phoneNo;
        this.username = username;
    }

    public User(String address, String email, String fullName,
                EGender gender, String passHash, String phoneNo, String username) {
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.passHash = passHash;
        this.phoneNo = phoneNo;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", passHash='" + passHash + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", username='" + username + '\'' +
                '}';
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
