package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Customer;
import com.boot.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/getall")
	public List<Customer>getAllCustomer(){
		return (List<Customer>) customerService.findAll();
	}

	@RequestMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) {
		System.out.println("Fetching ID: " + id);
		Customer customer = customerService.findOne(id);
		if(customer == null) {
			System.out.println("ID " + id + " not found");
		}
		return customer;
	}
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomerById(@PathVariable("id") int id) {
		Customer customer = customerService.findOne(id);
		if(customer == null) {
			return;
		}
		customerService.delete(id);
	}
	
	@PutMapping("/update")
	public Customer update(@RequestBody Customer customer) {
		Customer customerUpdate = customerService.findOne(customer.getId());
		if(customerUpdate != null) {
			customerService.save(customerUpdate);
		}
	return customerUpdate;
	}
	
}
