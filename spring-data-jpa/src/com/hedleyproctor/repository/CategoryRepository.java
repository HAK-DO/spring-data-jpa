package com.hedleyproctor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hedleyproctor.domain.Category;

/**
 * @author hdlee <br/>
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, String>{}
