package com.hedleyproctor.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.googlecode.flickrjandroid.service.FlickrService;
import com.hedleyproctor.domain.BannerData;

/**
 * @author hdlee
 */
@Service
public class BannerService {

	@Autowired FlickrService flickrService;
	@Autowired private Environment env;
	
	@PostConstruct
	@Cacheable(value="default")
	public List<BannerData> getBanners() {
		return flickrService.getBanners(env.getProperty("flickr.key"), env.getProperty("flickr.id"));
	}
}