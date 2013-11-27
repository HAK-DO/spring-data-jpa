package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{}
