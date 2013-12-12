package com.googlecode.flickrjandroid.photosets;

import java.io.Serializable;

import com.googlecode.flickrjandroid.people.User;
import com.googlecode.flickrjandroid.photos.Photo;
import com.googlecode.flickrjandroid.photos.PhotoList;

public class Photoset implements Serializable {
	private static final long serialVersionUID = 12L;
	private String id;
	private String url;
	private User owner;
	private Photo primaryPhoto;
	private String secret;
	private String server;
	private String farm;
	private int photoCount;
	private String title;
	private String description;
	private PhotoList photoList;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		if (this.url == null) {
			StringBuffer sb = new StringBuffer();
			sb.append("http://www.flickr.com/photos/");
			sb.append(getOwner().getId());
			sb.append("/sets/");
			sb.append(getId());
			sb.append("/");
			return sb.toString();
		}
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getOwner() {
		return this.owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Photo getPrimaryPhoto() {
		return this.primaryPhoto;
	}

	public void setPrimaryPhoto(Photo primaryPhoto) {
		this.primaryPhoto = primaryPhoto;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getServer() {
		return this.server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getFarm() {
		return this.farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public int getPhotoCount() {
		return this.photoCount;
	}

	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}

	public void setPhotoCount(String photoCount) {
		if (photoCount != null)
			setPhotoCount(Integer.parseInt(photoCount));
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PhotoList getPhotoList() {
		return this.photoList;
	}

	public void setPhotoList(PhotoList photoList) {
		this.photoList = photoList;
	}

	public int hashCode() {
		int result = 1;
		result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (super.getClass() != obj.getClass())
			return false;
		Photoset other = (Photoset) obj;
		if (this.id == null)
			if (other.id != null)
				return false;
			else if (!(this.id.equals(other.id)))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tid: " + id + "\n\turl: " + url + "\n\towner: " + owner + "\n\tprimaryPhoto: " + primaryPhoto + "\n\tsecret: " + secret + "\n\tserver: " + server + "\n\tfarm: " + farm + "\n\tphotoCount: " + photoCount + "\n\ttitle: " + title + "\n\tdescription: " + description + "\n\tphotoList: " + photoList + "\n}";
	}

	
}