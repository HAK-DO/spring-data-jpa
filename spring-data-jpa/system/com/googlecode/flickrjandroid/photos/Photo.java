package com.googlecode.flickrjandroid.photos;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.people.User;
import com.googlecode.flickrjandroid.tags.Tag;

@SuppressWarnings({ "rawtypes", "unchecked","unused" })
public class Photo implements Serializable {
	public static final long serialVersionUID = 12L;
	private static final ThreadLocal<DateFormat> DATE_FORMATS = new ThreadLocal() {
		protected synchronized DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	private static final String SMALL_SQUARE_IMAGE_SUFFIX = "_s.jpg";
	private static final String LARGE_SQUARE_IMAGE_SUFFIX = "_q.jpg";
	private static final String THUMBNAIL_IMAGE_SUFFIX = "_t.jpg";
	private static final String SMALL_IMAGE_SUFFIX = "_m.jpg";
	private static final String SMALL_320_IMAGE_SUFFIX = "_n.jpg";
	private static final String MEDIUM_IMAGE_SUFFIX = ".jpg";
	private static final String MEDIUM_640_IMAGE_SUFFIX = "_z.jpg";
	private static final String MEDIUM_800_IMAGE_SUFFIX = "_c.jpg";
	private static final String LARGE_IMAGE_SUFFIX = "_b.jpg";
	private static final String LARGE_1600_IMAGE_SUFFIX = "_h.jpg";
	private static final String LARGE_2048_IMAGE_SUFFIX = "_k.jpg";
	private static final String DEFAULT_ORIGINAL_IMAGE_SUFFIX = "_o.jpg";
	private Size squareSize;
	private Size largeSquareSize;
	private Size thumbnailSize;
	private Size smallSize;
	private Size small320Size;
	private Size mediumSize;
	private Size medium640Size;
	private Size medium800Size;
	private Size largeSize;
	private Size large1600Size;
	private Size large2048Size;
	private Size originalSize;
	private String id;
	private User owner;
	private String secret;
	private String farm;
	private String server;
	private boolean favorite;
	private String license;
	private boolean primary;
	private String title;
	private String description;
	private boolean publicFlag;
	private boolean friendFlag;
	private boolean familyFlag;
	private Date dateAdded;
	private Date datePosted;
	private Date dateTaken;
	private Date lastUpdate;
	private String takenGranularity;
	private Permissions permissions;
	private Editability editability;
	private int comments = -1;
	private int views = -1;
	private int favorites = -1;
	private int rotation;
	private Collection<Note> notes;
	private Collection<Tag> tags;
	private Collection<PhotoUrl> urls;
	private String iconServer;
	private String iconFarm;
	private String url;
	private GeoData geoData;
	private String originalFormat;
	private String originalSecret;
	private String placeId;
	private String media;
	private String mediaStatus;
	private String pathAlias;
	private int originalWidth;
	private int originalHeight;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getOwner() {
		return this.owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getFarm() {
		return this.farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public String getServer() {
		return this.server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public boolean isFavorite() {
		return this.favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public boolean isPrimary() {
		return this.primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public void setPrimary(String primary) {
		setPrimary("1".equals(primary));
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

	public boolean isPublicFlag() {
		return this.publicFlag;
	}

	public void setPublicFlag(boolean publicFlag) {
		this.publicFlag = publicFlag;
	}

	public boolean isFriendFlag() {
		return this.friendFlag;
	}

	public void setFriendFlag(boolean friendFlag) {
		this.friendFlag = friendFlag;
	}

	public boolean isFamilyFlag() {
		return this.familyFlag;
	}

	public void setFamilyFlag(boolean familyFlag) {
		this.familyFlag = familyFlag;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public void setDateAdded(long dateAdded) {
		setDateAdded(new Date(dateAdded));
	}

	public void setDateAdded(String dateAdded) {
		if ((dateAdded == null) || ("".equals(dateAdded)))
			return;
		setDateAdded(Long.parseLong(dateAdded) * 1000L);
	}

	public Date getDatePosted() {
		return this.datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public void setDatePosted(long datePosted) {
		setDatePosted(new Date(datePosted));
	}

	public void setDatePosted(String datePosted) {
		if ((datePosted == null) || ("".equals(datePosted)))
			return;
		setDatePosted(Long.parseLong(datePosted) * 1000L);
	}

	public Date getDateTaken() {
		return this.dateTaken;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	public void setDateTaken(String dateTaken) {
		if ((dateTaken == null) || ("".equals(dateTaken)))
			return;
		try {
			setDateTaken(((DateFormat) DATE_FORMATS.get()).parse(dateTaken));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setLastUpdate(String lastUpdateStr) {
		if ((lastUpdateStr == null) || ("".equals(lastUpdateStr)))
			return;
		long unixTime = Long.parseLong(lastUpdateStr);
		setLastUpdate(new Date(unixTime * 1000L));
	}

	public String getTakenGranularity() {
		return this.takenGranularity;
	}

	public void setTakenGranularity(String takenGranularity) {
		this.takenGranularity = takenGranularity;
	}

	public Permissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

	public Editability getEditability() {
		return this.editability;
	}

	public void setEditability(Editability editability) {
		this.editability = editability;
	}

	public int getComments() {
		return this.comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public void setComments(String comments) {
		if (comments == null)
			return;
		setComments(Integer.parseInt(comments));
	}

	public Collection<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}

	public Collection<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}

	public Collection<PhotoUrl> getUrls() {
		return this.urls;
	}

	public void setUrls(Collection<PhotoUrl> urls) {
		this.urls = urls;
	}

	public void setViews(String views) {
		if (views == null)
			return;
		try {
			setViews(Integer.parseInt(views));
		} catch (NumberFormatException e) {
			setViews(-1);
		}
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getViews() {
		return this.views;
	}

	public int getFavorites() {
		return this.favorites;
	}

	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}

	public void setRotation(String rotation) {
		if (rotation == null)
			return;
		try {
			setRotation(Integer.parseInt(rotation));
		} catch (NumberFormatException e) {
			setRotation(-1);
		}
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getRotation() {
		return this.rotation;
	}

	public String getIconServer() {
		return this.iconServer;
	}

	public void setIconServer(String iconServer) {
		this.iconServer = iconServer;
	}

	public String getIconFarm() {
		return this.iconFarm;
	}

	public void setIconFarm(String iconFarm) {
		this.iconFarm = iconFarm;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GeoData getGeoData() {
		return this.geoData;
	}

	public void setGeoData(GeoData geoData) {
		this.geoData = geoData;
	}

	public boolean hasGeoData() {
		return (this.geoData != null);
	}

	public String getOriginalFormat() {
		return this.originalFormat;
	}

	public void setOriginalFormat(String originalFormat) {
		this.originalFormat = originalFormat;
	}

	public String getOriginalSecret() {
		return this.originalSecret;
	}

	public void setOriginalSecret(String originalSecret) {
		this.originalSecret = originalSecret;
	}

	/** @deprecated */
	public InputStream getOriginalAsStream() throws IOException, FlickrException {
		if (this.originalFormat != null) {
			return getOriginalImageAsStream("_o." + this.originalFormat);
		}
		return getOriginalImageAsStream("_o.jpg");
	}

	public String getOriginalUrl() throws FlickrException {
		if (this.originalSize == null) {
			if (this.originalFormat != null) {
				return getOriginalBaseImageUrl() + "_o." + this.originalFormat;
			}
			return getOriginalBaseImageUrl() + "_o.jpg";
		}
		return this.originalSize.getSource();
	}

	/** @deprecated */
	public InputStream getSmallSquareAsInputStream() throws IOException {
		return getImageAsStream("_s.jpg");
	}

	public String getSmallSquareUrl() {
		if (this.squareSize == null) {
			return getBaseImageUrl() + "_s.jpg";
		}
		return this.squareSize.getSource();
	}

	public String getLargeSquareUrl() {
		if (this.largeSquareSize == null) {
			return getBaseImageUrl() + "_q.jpg";
		}
		return this.largeSquareSize.getSource();
	}

	/** @deprecated */
	public InputStream getThumbnailAsInputStream() throws IOException {
		return getImageAsStream("_t.jpg");
	}

	public String getThumbnailUrl() {
		if (this.thumbnailSize == null) {
			return getBaseImageUrl() + "_t.jpg";
		}
		return this.thumbnailSize.getSource();
	}

	/** @deprecated */
	public InputStream getSmallAsInputStream() throws IOException {
		return getImageAsStream("_m.jpg");
	}

	public String getSmallUrl() {
		if (this.smallSize == null) {
			return getBaseImageUrl() + "_m.jpg";
		}
		return this.smallSize.getSource();
	}

	public String getSmall320Url() {
		if (this.small320Size == null) {
			return getBaseImageUrl() + "_n.jpg";
		}
		return this.small320Size.getSource();
	}

	/** @deprecated */
	public InputStream getMediumAsStream() throws IOException {
		return getImageAsStream(".jpg");
	}

	public String getMediumUrl() {
		if (this.mediumSize == null) {
			return getBaseImageUrl() + ".jpg";
		}
		return this.mediumSize.getSource();
	}

	public String getMedium640Url() {
		if (this.medium640Size == null) {
			return getBaseImageUrl() + "_z.jpg";
		}
		return this.medium640Size.getSource();
	}

	public String getMedium800Url() {
		if (this.medium800Size == null) {
			return getBaseImageUrl() + "_c.jpg";
		}
		return this.medium800Size.getSource();
	}

	/** @deprecated */
	public InputStream getLargeAsStream() throws IOException {
		return getImageAsStream("_b.jpg");
	}

	public String getLargeUrl() {
		if (this.largeSize == null) {
			return getBaseImageUrl() + "_b.jpg";
		}
		return this.largeSize.getSource();
	}

	public String getLarge1600Url() {
		if (this.large1600Size == null) {
			return getBaseImageUrl() + "_h.jpg";
		}
		return this.large1600Size.getSource();
	}

	public String getLarge2048Url() {
		if (this.large2048Size == null) {
			return getBaseImageUrl() + "_k.jpg";
		}
		return this.large2048Size.getSource();
	}

	/** @deprecated */
	private InputStream getImageAsStream(String suffix) throws IOException {
		StringBuffer buffer = getBaseImageUrl();
		buffer.append(suffix);
		return _getImageAsStream(buffer.toString());
	}

	/** @deprecated */
	private InputStream getOriginalImageAsStream(String suffix) throws IOException, FlickrException {
		StringBuffer buffer = getOriginalBaseImageUrl();
		buffer.append(suffix);
		return _getImageAsStream(buffer.toString());
	}

	private InputStream _getImageAsStream(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		return conn.getInputStream();
	}

	private StringBuffer getBaseImageUrl() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(_getBaseImageUrl());
		buffer.append(getSecret());
		return buffer;
	}

	private StringBuffer getOriginalBaseImageUrl() throws FlickrException, NullPointerException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(_getBaseImageUrl());
		if (getOriginalSecret().length() > 8)
			buffer.append(getOriginalSecret());
		else {
			throw new FlickrException("0", "OriginalUrl not available because of missing originalsecret.");
		}

		return buffer;
	}

	private StringBuffer _getBaseImageUrl() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("http://farm");
		buffer.append(getFarm());
		buffer.append(".static.flickr.com/");
		buffer.append(getServer());
		buffer.append("/");
		buffer.append(getId());
		buffer.append("_");
		return buffer;
	}

	public String getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getMedia() {
		return this.media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getMediaStatus() {
		return this.mediaStatus;
	}

	public void setMediaStatus(String mediaStatus) {
		this.mediaStatus = mediaStatus;
	}

	public int getOriginalWidth() {
		return this.originalWidth;
	}

	public void setOriginalWidth(String originalWidth) {
		try {
			setOriginalWidth(Integer.parseInt(originalWidth));
		} catch (NumberFormatException ex) {
		}
	}

	public void setOriginalWidth(int originalWidth) {
		this.originalWidth = originalWidth;
	}

	public int getOriginalHeight() {
		return this.originalHeight;
	}

	public void setOriginalHeight(String originalHeight) {
		try {
			setOriginalHeight(Integer.parseInt(originalHeight));
		} catch (NumberFormatException ex) {
		}
	}

	public void setOriginalHeight(int originalHeight) {
		this.originalHeight = originalHeight;
	}

	public void setSizes(Collection<Size> sizes) {
		Iterator it = sizes.iterator();
		while (it.hasNext()) {
			Size size = (Size) it.next();
			if (size.getLabel() == 1)
				this.squareSize = size;
			else if (size.getLabel() == 6)
				this.largeSquareSize = size;
			else if (size.getLabel() == 0)
				this.thumbnailSize = size;
			else if (size.getLabel() == 2)
				this.smallSize = size;
			else if (size.getLabel() == 10)
				this.small320Size = size;
			else if (size.getLabel() == 3)
				this.mediumSize = size;
			else if (size.getLabel() == 11)
				this.medium640Size = size;
			else if (size.getLabel() == 12)
				this.medium800Size = size;
			else if (size.getLabel() == 4)
				this.largeSize = size;
			else if (size.getLabel() == 13)
				this.large1600Size = size;
			else if (size.getLabel() == 14)
				this.large2048Size = size;
			else if (size.getLabel() == 5)
				this.originalSize = size;
		}
	}

	public Size getSquareSize() {
		return this.squareSize;
	}

	public Size getSmallSize() {
		return this.smallSize;
	}

	public Size getThumbnailSize() {
		return this.thumbnailSize;
	}

	public Size getMediumSize() {
		return this.mediumSize;
	}

	public Size getLargeSize() {
		return this.largeSize;
	}

	public Size getLargeSquareSize() {
		return this.largeSquareSize;
	}

	public Size getOriginalSize() {
		return this.originalSize;
	}

	public String getPathAlias() {
		return this.pathAlias;
	}

	public void setPathAlias(String pathAlias) {
		this.pathAlias = pathAlias;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = 31 * result + ((this.title == null) ? 0 : this.title.hashCode());
		result = 31 * result + ((this.url == null) ? 0 : this.url.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Photo))
			return false;
		Photo other = (Photo) obj;
		if (this.id == null)
			if (other.id != null)
				return false;
			else if (!(this.id.equals(other.id)))
				return false;
		if (this.title == null)
			if (other.title != null)
				return false;
			else if (!(this.title.equals(other.title)))
				return false;
		if (this.url == null)
			if (other.url != null)
				return false;
			else if (!(this.url.equals(other.url)))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "Photo [squareSize=" + squareSize + ", largeSquareSize=" + largeSquareSize + ", thumbnailSize=" + thumbnailSize + ", smallSize=" + smallSize + ", small320Size=" + small320Size + ", mediumSize=" + mediumSize + ", medium640Size=" + medium640Size + ", medium800Size=" + medium800Size + ", largeSize=" + largeSize + ", large1600Size=" + large1600Size + ", large2048Size=" + large2048Size + ", originalSize=" + originalSize + ", id=" + id + ", owner=" + owner + ", secret=" + secret + ", farm=" + farm + ", server=" + server + ", favorite=" + favorite + ", license=" + license + ", primary=" + primary + ", title=" + title + ", description=" + description + ", publicFlag=" + publicFlag + ", friendFlag=" + friendFlag + ", familyFlag=" + familyFlag + ", dateAdded=" + dateAdded + ", datePosted=" + datePosted + ", dateTaken=" + dateTaken + ", lastUpdate=" + lastUpdate + ", takenGranularity=" + takenGranularity + ", permissions=" + permissions + ", editability=" + editability + ", comments=" + comments + ", views=" + views + ", favorites=" + favorites + ", rotation=" + rotation + ", notes=" + notes + ", tags=" + tags + ", urls=" + urls + ", iconServer=" + iconServer + ", iconFarm=" + iconFarm + ", url=" + url + ", geoData=" + geoData + ", originalFormat=" + originalFormat + ", originalSecret=" + originalSecret + ", placeId=" + placeId + ", media=" + media + ", mediaStatus=" + mediaStatus + ", pathAlias=" + pathAlias + ", originalWidth=" + originalWidth + ", originalHeight=" + originalHeight + "]";
	}
	
}