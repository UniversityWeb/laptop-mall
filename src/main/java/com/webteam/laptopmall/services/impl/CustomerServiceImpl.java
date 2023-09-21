package com.webteam.laptopmall.services.impl;

import com.webteam.laptopmall.daos.CustomerDAO;
import com.webteam.laptopmall.exceptions.CustomerNotFoundException;
import com.webteam.laptopmall.models.Customer;
import com.webteam.laptopmall.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;

    public CustomerServiceImpl() {
        customerDAO = new CustomerDAO();
    }

    @Override
    public Customer add(Customer cus) {
        return customerDAO.add(cus);
    }

    @Override
    public Customer update(Customer cus) {
        if (getById(cus.getId()) == null)
            throw new CustomerNotFoundException("Count not find any customers with id=" + cus.getId());
        return customerDAO.update(cus);
    }

    @Override
    public boolean deleteById(Long id) {
        if (getById(id) == null)
            throw new CustomerNotFoundException("Count not find any customers with id=" + id);
        return customerDAO.deleteById(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerDAO.getById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Count not find any customers with id=" + id));
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }
}
