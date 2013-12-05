package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Item;

/**
 * @author hdlee <br/>
 */
public interface ItemRepository extends CrudRepository<Item, String> {}
