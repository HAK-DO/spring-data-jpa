package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Category;

/**
 * @author hdlee <br/>
 */
public interface CategoryRepository extends CrudRepository<Category, String>{}
