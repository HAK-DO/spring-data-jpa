package com.googlecode.flickrjandroid.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.github.dybskiy.redactor.model.RedactorImage;
import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.photos.Photo;
import com.googlecode.flickrjandroid.photos.PhotoList;
import com.googlecode.flickrjandroid.photosets.Photoset;
import com.googlecode.flickrjandroid.photosets.Photosets;
import com.googlecode.flickrjandroid.photosets.PhotosetsInterface;
import com.hedleyproctor.domain.BannerData;

/**
 * @author hdlee
 * cache - http://www.java-allandsundry.com/2012/08/spring-configuration-and-factorybean.html 
 */
@Service
public class FlickrService {

	/**
	 * @param key
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getRedactorImage(String key, String userId){
		Flickr f = new Flickr(key);
		PhotosetsInterface photosetsInterface = f.getPhotosetsInterface();
		Photosets photosets;
		List images = new ArrayList();
		try {
			photosets = photosetsInterface.getList(userId);
			for (Photoset photoset : photosets.getPhotosets()) {
				Photoset photos = photosetsInterface.getPhotos(photoset.getId(), 100, 1);
				RedactorImage image = new RedactorImage();
				PhotoList photoList = photos.getPhotoList();
				for (Photo photo : photoList) {
					image.setFolder(photos.getTitle());
					image.setTitle(photos.getTitle());
					image.setThumb(photo.getSmallUrl());
					image.setImage(photo.getOriginalUrl());
					images.add(image);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FlickrException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return images;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<BannerData> getBanners(String key, String userId){
		Flickr f = new Flickr(key);
		PhotosetsInterface photosetsInterface = f.getPhotosetsInterface();
		Photosets photosets;
		List banners = new ArrayList();
		try {
			photosets = photosetsInterface.getList(userId);
			for (Photoset photoset : photosets.getPhotosets()) {
				Photoset photos = photosetsInterface.getPhotos(photoset.getId(), 100, 1);
				if("Flickr Trends - March 2012".indexOf(photoset.getTitle()) != -1){
					BannerData bannerData = new BannerData();
					PhotoList photoList = photos.getPhotoList();
					for (Photo photo : photoList) {
						bannerData.setTitle(photo.getTitle());
						bannerData.setImageUrl(photo.getLarge1600Url());
						bannerData.setDescription(photo.getDescription());
						banners.add(bannerData);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FlickrException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return banners;
	}
}
