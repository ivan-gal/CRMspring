package com.example.testing.service;

import com.example.testing.dao.CustomerDAO;
import com.example.testing.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public Iterable<Customer> getCustomers(){
        return customerDAO.findAll();
    }

    @Transactional
    public void saveCustomer(Customer theCustomer){
        customerDAO.save(theCustomer);
    }

    @Transactional
    public Iterable<Customer> getCustomerByLastName(){
        return customerDAO.findCustomersbyLastName();
    }

    @Transactional
    public Customer getCustomer(int id){
       return customerDAO.findById(id).orElse(null);
    }

    @Transactional
    public void deleteCustomer(int Id){
        customerDAO.deleteById(Id);
    }

}
