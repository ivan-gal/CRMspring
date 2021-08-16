package com.example.testing.dao;

import com.example.testing.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customer order by last_name", nativeQuery = true)
    Iterable<Customer> findCustomersbyLastName();



}
