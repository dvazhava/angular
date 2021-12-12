package com.example.customerproducer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerproducer.dao.consumerDao;
import com.example.customerproducer.model.customer;
import com.example.customerproducer.service.customerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//CrossOrigin(origins = "*")
@RestController
public class customeController {
	
	@Autowired
	customerService customerservice;
	
	@Autowired
	consumerDao customerdao;
	
	private static final Logger logger = LoggerFactory.getLogger(customeController.class);
	
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<customer>> getCustomerbyid(@PathVariable ("id") long id) {
		logger.info("--------------------------------------Customer producer-------------------------------");
		Optional<customer> cust=customerservice.findById((int) id);
		logger.info("Fetched the details of customer"+id);
		return ResponseEntity.ok(cust);
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<customer>  updateById(@PathVariable ("id") long id,@RequestBody customer customer) {
		
		customer cust=customerservice.getById((int)id);
		cust.setName(customer.getName());
		cust.setAccount(customer.getAccount());
		cust.setAddress(customer.getAddress());
		cust.setAge(customer.getAge());
		customerservice.createCustomer(cust);
		logger.info("Updated the details of customer by id"+id);
		return ResponseEntity.ok(customerservice.createCustomer(cust));
	}
	
	
	@GetMapping("/getAllCustomerDetails")
	@HystrixCommand(fallbackMethod = "customerFallbackGetAll")
	public List<customer> getAll(){
		logger.info("Fetched the details of  all customers");
		return (List<customer>) customerservice.getAll();
	}
	
	@PostMapping("/createCustomer")
	@HystrixCommand(fallbackMethod = "CreateFallback")
	public customer create(@RequestBody customer customer) {
		logger.info("Created new customer");
	return 	customerservice.createCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	@HystrixCommand(fallbackMethod = "customerFallbackUpdate")
	public String updateCustomer(@RequestBody customer customer) {
		customer obj=new customer();
		obj.setId(customer.getId());
		obj.setName(customer.getName());
		obj.setAge(customer.getAge());
		obj.setAccount(customer.getAccount());
		obj.setAddress(customer.getAddress());
		customerservice.createCustomer(obj);
		
		return "updated successflly";
		
	}
	@DeleteMapping("/delete/{id}")
	@HystrixCommand(fallbackMethod = "customerFallback")
	public boolean deleteById(@PathVariable("id") int id) {
		return customerservice.deleteById(id);
	}
	
		
	
	
	public List<customer> customerFallbackGetAll(){
		List<customer> customer= new ArrayList<>();
		customer fallback= new customer();
		fallback.setName("fallback Customer");
		fallback.setAddress("fallback address");
		fallback.setAge(17);
		fallback.setId(5);
		fallback.setAccount("fallback account");
		customer.add(fallback);
		return customer;
	}

    public boolean customerFallback(int id) {
    	System.out.println("Customer service is down !!! fallback is enabled...." + id);
    	return true;
    }
	
    public String customerFallbackUpdate(customer cust ) {
    	return "Customer service is down !!! fallback is enabled....";
    }
    
    public customer CreateFallback(customer cust) {
    	customer fallback= new customer();
		fallback.setName("fallback Customer");
		fallback.setAddress("fallback address");
		fallback.setAge(17);
		fallback.setId(5);
		fallback.setAccount("fallback account");
		return fallback;
    	
    }

}
