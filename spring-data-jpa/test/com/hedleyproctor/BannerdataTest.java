package com.hedleyproctor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hedleyproctor.domain.BannerData;
import com.hedleyproctor.domain.Category;
import com.hedleyproctor.repository.BannerRepository;
import com.hedleyproctor.repository.CategoryRepository;
import config.AppConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BannerdataTest {

	@Autowired BannerRepository bannerRepository;
	@Autowired CategoryRepository categoryRepository;
	
	@Test
	public void insertBannerdata(){
		Category category = categoryRepository.findOne("TEST");
		if (category != null) {
			BannerData bannerData = new BannerData();
			bannerData.setFavouriteCategoryId(category.getCategoryId());
			bannerRepository.save(bannerData);
		}
	}
}
