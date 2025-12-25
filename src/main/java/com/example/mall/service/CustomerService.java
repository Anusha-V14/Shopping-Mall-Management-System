

package com.example.mall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.entity.Customer;
import com.example.mall.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save a new customer
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get customer by ID
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    // Update customer by ID
    public Customer update(Long id, Customer customerDetails) {
        Customer existing = customerRepository.findById(id).get();

        existing.setName(customerDetails.getName());
        existing.setEmail(customerDetails.getEmail());
        existing.setPhone(customerDetails.getPhone());
        return customerRepository.save(existing);
    }

    // Delete customer by ID
    public String delete(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return "Customer deleted with ID = " + id;
        } else {
            return "Customer not found with ID = " + id;
        }
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}



