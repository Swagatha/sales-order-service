package com.onlineshopping.salesorderservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Customer;

public interface CustomerSORepository extends JpaRepository<Customer, Long> {

}
