package com.onlineshopping.salesorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.dto.SalesOrderDTO;
import com.onlineshopping.model.SalesOrder;
import com.onlineshopping.service.SalesOrderService;

//@RequestMapping("/orders")
@RestController
public class SalesOrderServiceController {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderServiceController.class);
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private SalesOrderService salesOrderService;
	
	@PostMapping("/salesorder")
	public SalesOrder createOrder(@RequestBody SalesOrder salesOrder) {
		return salesOrderRepository.saveAndFlush(salesOrder);	
	}
	
	@PostMapping("/salesorder")
	@ResponseStatus(HttpStatus.CREATED)
	public SalesOrderDTO add(@RequestBody SalesOrderDTO salesOrderDTO) {
		return salesOrderService.save(salesOrderDTO);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Throwable ex) {
		LOG.error("There was an error: ", ex);
		// Add conditional logic to show different status on different exceptions
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}	
