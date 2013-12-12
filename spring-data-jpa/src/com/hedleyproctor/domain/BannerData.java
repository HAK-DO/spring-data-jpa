package com.hedleyproctor.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Igor Baiborodine
 */
@Entity(name = "bannerdata")
public class BannerData implements Serializable {

	private static final long serialVersionUID = -786805636060027821L;

	@Id
    @Nonnull
    @Column(name = "favcategory", unique = true, nullable = false, length = 30)
    private String favouriteCategoryId;

    @Column(name = "bannername", nullable = true, length = 255)
    private String bannerName;
    
    @Column(name = "imageUrl", nullable = true, length = 255)
    private String imageUrl;
    
    @Column(name = "seq")
    private int seq;
    
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    
    @Column(name = "title")
    private String title;
    

    public BannerData() {}

    public BannerData(@Nonnull String favouriteCategoryId, @Nullable String bannerName) {
        checkNotNull(favouriteCategoryId, "Argument[favoriteCategoryId] must not be null");

        this.favouriteCategoryId = favouriteCategoryId;
        this.bannerName = bannerName;
    }

    public String getFavouriteCategoryId() {
        return favouriteCategoryId;
    }

    public void setFavouriteCategoryId(@Nullable final String favouriteCategoryId) {
        this.favouriteCategoryId = favouriteCategoryId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(@Nullable final String bannerName) {
        this.bannerName = bannerName;
    }

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tfavouriteCategoryId: " + favouriteCategoryId + "\n\tbannerName: " + bannerName + "\n\timageUrl: " + imageUrl + "\n\tseq: " + seq + "\n\tdescription: " + description + "\n\ttitle: " + title + "\n}";
	}
    
}
