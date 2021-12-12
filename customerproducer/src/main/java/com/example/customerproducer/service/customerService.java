package com.example.customerproducer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerproducer.dao.consumerDao;
import com.example.customerproducer.model.customer;
@Service
@Transactional
public class customerService {
	@Autowired
	consumerDao dao;

	public Iterable<customer> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public customer createCustomer(customer customer) {
		// TODO Auto-generated method stub
		return dao.save(customer);
	}

	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		if(dao.findById(id) != null) {
			dao.deleteById(id);
			return true ;
		}
		
	
		
		return false ;
	}

	public Optional<customer> findById(int id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id);
	}

	public customer getById(int id) {
		// TODO Auto-generated method stub
		if(dao.findById(id) != null) {
			dao.getById(id);
			
		}
		return dao.getById(id) ;
	}

}
