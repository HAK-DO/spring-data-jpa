package com.hedleyproctor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hedleyproctor.domain.BannerData;

/**
 * @author hdlee <br/>
 */
public interface BannerRepository extends PagingAndSortingRepository<BannerData, String>{}
