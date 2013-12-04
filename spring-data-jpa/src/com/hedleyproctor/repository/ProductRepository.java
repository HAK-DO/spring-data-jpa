package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Product;

/**
 * @author hdlee <br/>
 */
public interface ProductRepository extends CrudRepository<Product, String>{}
