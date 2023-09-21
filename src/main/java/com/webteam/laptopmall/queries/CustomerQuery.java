package com.webteam.laptopmall.queries;

import com.webteam.laptopmall.models.Customer;

public class CustomerQuery {
    private static final String TBL_NAME = "customers";
    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASS = "pass_hash";
    public static final String EMAIL = "email";
    public static final String ADDRESS = "address";
    public static final String PHONE_NO = "phone_no";
    public static final String FULL_NAME = "full_name";
    public static final String GENDER = "gender";

    public String buildAddQuery(Customer cus) {
        return String.format("INSERT INTO `%s` (`%s`, `%s`, `%s`, `%s`, `%s`, `%s`, `%s`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                TBL_NAME, USERNAME, PASS, EMAIL, ADDRESS, PHONE_NO, FULL_NAME, GENDER,
                cus.getUsername(), cus.getPassHash(), cus.getEmail(), cus.getAddress(),
                cus.getPhoneNo(), cus.getFullName(), cus.getGender().toString());
    }

    public String buildUpdateQuery(Customer cus) {
        return String.format("UPDATE `%s` SET `%s` = '%s', `%s` = '%s', `%s` = '%s', `%s` = '%s', " +
                        "`%s` = '%s', `%s` = '%s', `%s` = '%s' WHERE `%s` = %d",
                TBL_NAME, USERNAME, cus.getUsername(), PASS, cus.getPassHash(), EMAIL, cus.getEmail(),
                ADDRESS, cus.getAddress(), PHONE_NO, cus.getPhoneNo(), FULL_NAME, cus.getFullName(),
                GENDER, cus.getGender().toString(), ID, cus.getId());
    }

    public String buildDeleteByIdQuery(Long id) {
        return String.format("DELETE FROM `%s` WHERE %s = %d", TBL_NAME, ID, id);
    }

    public String buildGetByIdQuery(Long id) {
        return String.format("SELECT * FROM `%s` WHERE %s = %d", TBL_NAME, ID, id);
    }

    public String buildGetAllQuery() {
        return String.format("SELECT * FROM `%s`", TBL_NAME);
    }
}
