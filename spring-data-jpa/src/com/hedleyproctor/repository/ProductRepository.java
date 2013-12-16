package com.hedleyproctor.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hedleyproctor.domain.Category;
import com.hedleyproctor.domain.Product;

/**
 * @author hdlee <br/> 
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
	@Query(value = "select max(p.productid) from #{#entityName} p where p.categoryid = :categoryId and date_format(p.createdate,'%X%m') = date_format(curdate(),'%X%m')", nativeQuery = true)
	String getMaxByCategoryId(@Param("categoryId") String categoryId);
	List<Product> findByCategory(Category category, Pageable pageable);
}
