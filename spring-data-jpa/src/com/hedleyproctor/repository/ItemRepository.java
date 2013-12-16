package com.hedleyproctor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hedleyproctor.domain.Item;

/**
 * @author hdlee <br/>
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, String> {}
