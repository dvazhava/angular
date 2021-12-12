package com.example.customerproducer.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.customerproducer.dao.consumerDao;
import com.example.customerproducer.model.customer;

@SpringBootTest
public class CustomerServiceTest {
	
	@MockBean
	private consumerDao dao;
	
	@Autowired
	customerService service;
	
	@Test
    public void testCreateCustomer(){
        customer cust=new customer();
		
		cust.setId(122);
		cust.setName("Rasthi");
		cust.setAddress("anna nagar chennai");
		cust.setAccount("savings");
		
		Mockito.when(dao.save(cust)).thenReturn(cust);
        assertThat(service.createCustomer(cust)).isEqualTo(cust);
    
		
		
	}
	
	}


