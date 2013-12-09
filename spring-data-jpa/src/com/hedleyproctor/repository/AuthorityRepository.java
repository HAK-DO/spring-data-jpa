package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, String> {}