package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.BannerData;

/**
 * @author hdlee <br/>
 */
public interface BannerRepository extends CrudRepository<BannerData, String>{}
