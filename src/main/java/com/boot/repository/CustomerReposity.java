package com.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.Customer;

@Repository
public interface CustomerReposity extends CrudRepository<Customer, Integer>{

}
