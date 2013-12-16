package com.hedleyproctor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hedleyproctor.domain.Authority;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, String> {}