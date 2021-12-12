package com.example.customerproducer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.customerproducer.dao.consumerDao;
import com.example.customerproducer.model.customer;
import com.example.customerproducer.service.customerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(value = customeController.class )
public class CustomerControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired(required=true)
	private consumerDao dao;
	
	@MockBean
	private customerService customerservice;
	
	@Test
    public void testNewCustomer() throws Exception{
		
		String URI = "/createCustomer";
		
		customer cust=new customer();
		
		cust.setId(122);
		cust.setName("Rasthi");
		cust.setAddress("anna nagar chennai");
		cust.setAccount("savings");
		
		String jsonInput = this.converttoJson(cust);
		 Mockito.when(customerservice.createCustomer(Mockito.any(customer.class))).thenReturn(cust);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    
	}
	   private String converttoJson(Object cust) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(cust);
	    }
	   //save

}
