package com.hedleyproctor;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.googlecode.flickrjandroid.service.FlickrService;
import com.hedleyproctor.domain.BannerData;

import config.ApplicationConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BannerdataTest {

	@Autowired FlickrService flickrService;
	@Autowired Environment env;

	@Test
	public void getBanner(){
		List<BannerData> list = flickrService.getBanners(env.getProperty("flickr.key"), env.getProperty("flickr.id"));
		System.out.println(list);
		List<BannerData> list2 = flickrService.getBanners(env.getProperty("flickr.key"), env.getProperty("flickr.id"));
		System.out.println(list2);
	}
}
