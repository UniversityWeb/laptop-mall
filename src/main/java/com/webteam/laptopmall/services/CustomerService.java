package com.webteam.laptopmall.services;

import com.webteam.laptopmall.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer cus);
    Customer update(Customer cus);
    boolean deleteById(Long id);
    Customer getById(Long id);
    List<Customer> getAll();
}
