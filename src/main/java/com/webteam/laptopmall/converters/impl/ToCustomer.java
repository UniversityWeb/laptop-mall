package com.webteam.laptopmall.converters.impl;

import com.webteam.laptopmall.converters.Conv;
import com.webteam.laptopmall.enums.EGender;
import com.webteam.laptopmall.models.Customer;
import com.webteam.laptopmall.queries.CustomerQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToCustomer extends Conv<Customer> {

    @Override
    public Customer toModel(ResultSet rs) throws SQLException {
        Long id = rs.getLong(CustomerQuery.ID);
        String username = rs.getString(CustomerQuery.USERNAME);
        String passHash = rs.getString(CustomerQuery.PASS);
        String email = rs.getString(CustomerQuery.EMAIL);
        String address = rs.getString(CustomerQuery.ADDRESS);
        String phoneNo = rs.getString(CustomerQuery.PHONE_NO);
        String fullName = rs.getString(CustomerQuery.FULL_NAME);
        EGender gender = EGender.valueOf( rs.getString(CustomerQuery.GENDER) );
        return new Customer(
                id
                ,username
                ,passHash
                ,email
                ,address
                ,phoneNo
                ,fullName
                ,gender);
    }
}
