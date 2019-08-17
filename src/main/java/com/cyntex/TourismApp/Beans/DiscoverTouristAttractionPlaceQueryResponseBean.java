package com.cyntex.TourismApp.Beans;

public class DiscoverTouristAttractionPlaceQueryResponseBean {
	private String attractionName;
	private String description;
	private String ratingProfileId;
	private String locationId;
	private String titlePhotoUrl;
	private String photoCollectionId;
	public DiscoverTouristAttractionPlaceQueryResponseBean(
			String attractionName, String description, String ratingProfileId,
			String locationId, String titlePhotoUrl, String photoCollectionId) {
		super();
		this.attractionName = attractionName;
		this.description = description;
		this.ratingProfileId = ratingProfileId;
		this.locationId = locationId;
		this.titlePhotoUrl = titlePhotoUrl;
		this.photoCollectionId = photoCollectionId;
	}
	public String getAttractionName() {
		return attractionName;
	}
	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRatingProfileId() {
		return ratingProfileId;
	}
	public void setRatingProfileId(String ratingProfileId) {
		this.ratingProfileId = ratingProfileId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getTitlePhotoUrl() {
		return titlePhotoUrl;
	}
	public void setTitlePhotoUrl(String titlePhotoUrl) {
		this.titlePhotoUrl = titlePhotoUrl;
	}
	public String getPhotoCollectionId() {
		return photoCollectionId;
	}
	public void setPhotoCollectionId(String photoCollectionId) {
		this.photoCollectionId = photoCollectionId;
	}

	

}
