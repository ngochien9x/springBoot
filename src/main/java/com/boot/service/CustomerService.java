package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Customer;
import com.boot.repository.CustomerReposity;

@Service
public class CustomerService {
	@Autowired
	private CustomerReposity customerReposity;
	
	public Iterable<Customer> findAll(){
		return customerReposity.findAll();
	}
	
	public Customer findOne(int id) {
		return customerReposity.findOne(id);
	}
	
	public void save(Customer customer) {
		customerReposity.save(customer);
	}
	
	public void delete(int id) {
		customerReposity.delete(id);
	}
}
