package com.example.customerproducer.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customerproducer.model.customer;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerDaoTest {
	 @Autowired
	    private TestEntityManager testEntityManager;
	 
	 @Autowired
	  private consumerDao dao;
	 
	 @Test
	    public void testNewCustomer() throws Exception{
	        customer cust = getCustomer();
	        customer saveInDb = testEntityManager.persist(cust);
	        customer getFromInDb = dao.findById(saveInDb.getId()).get();
	        assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 
	 private customer getCustomer() {
		 customer cust=new customer();
			
			cust.setId(122);
			cust.setName("Rasthi");
			cust.setAddress("anna nagar chennai");
			cust.setAccount("savings");
			return cust;
	 }
		

}
