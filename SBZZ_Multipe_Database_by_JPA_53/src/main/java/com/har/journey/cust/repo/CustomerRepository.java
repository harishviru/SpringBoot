package com.har.journey.cust.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.cust.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
