package com.hedleyproctor.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hdlee
 */
@Service
public class HomeService {

	@Autowired BannerService bannerService;
	@Autowired ProductService productService;

	public Map<Object, Object> getHome(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("banners", bannerService.getBanners());
		map.put("newProducts", productService.newProducts());
		map.put("popularProducts", productService.popularProducts());
		return map;
	}
}