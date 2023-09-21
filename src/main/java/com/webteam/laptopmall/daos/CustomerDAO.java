package com.webteam.laptopmall.daos;

import com.webteam.laptopmall.models.Customer;
import com.webteam.laptopmall.models.UpdateResult;
import com.webteam.laptopmall.queries.CustomerQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO extends BaseDAO{
    private static final Logger log = Logger.getLogger(CustomerDAO.class.getName());

    private CustomerQuery customerQuery;

    public CustomerDAO() {
        super();
        customerQuery = new CustomerQuery();
    }

    public Customer add(Customer cus) {
        String query = customerQuery.buildAddQuery(cus);
        try {
            UpdateResult us = executeUpdateReturnGeneratedKey(query);
            if (us.isSuccess()) {
                long generatedId = us.getGeneratedKey();
                cus.setId(generatedId);
                return cus;
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public Customer update(Customer cus) {
        String query = customerQuery.buildUpdateQuery(cus);
        int effectRows = 0;
        try {
            effectRows = executeUpdate(query);
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return effectRows > 0 ? cus : null;
    }

    public boolean deleteById(Long id) {
        String query = customerQuery.buildDeleteByIdQuery(id);
        int effectRows = 0;
        try {
            effectRows = executeUpdate(query);
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return effectRows > 0;
    }

    public Optional<Customer> getById(Long id) {
        String query = customerQuery.buildGetByIdQuery(id);
        Optional<Customer> optCustomer = Optional.empty();
        try {
            optCustomer = getSingleObject(query, Customer.class);
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return optCustomer;
    }

    public List<Customer> getAll() {
        String query = customerQuery.buildGetAllQuery();
        List<Customer> customers = new ArrayList<>();
        try {
            customers = getList(query, Customer.class);
        } catch (SQLException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return customers;
    }
}
