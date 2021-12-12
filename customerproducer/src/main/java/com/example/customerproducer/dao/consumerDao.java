package com.example.customerproducer.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customerproducer.model.customer;

@Repository
@Transactional
public interface consumerDao extends JpaRepository<customer, Integer>{

}
