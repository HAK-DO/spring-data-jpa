package com.hedleyproctor;


import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{}
