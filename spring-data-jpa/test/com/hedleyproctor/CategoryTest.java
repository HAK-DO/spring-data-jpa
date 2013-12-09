package com.hedleyproctor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hedleyproctor.domain.Category;
import com.hedleyproctor.repository.CategoryRepository;

import config.ApplicationConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CategoryTest {

	@Autowired CategoryRepository categoryRepository;
	
	@Test 
	public void insertBannerdata(){
		Category category = new Category("TEST");
		categoryRepository.save(category);
	}

}
