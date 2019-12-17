package com.onlineshopping.salesorderservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
