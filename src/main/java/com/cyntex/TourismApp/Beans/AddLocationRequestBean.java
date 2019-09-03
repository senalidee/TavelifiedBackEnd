package com.cyntex.TourismApp.Beans;

public class AddLocationRequestBean {
	
	private String locationId;
	private double lng;
	private double lat;
	private String attractionName;
	private String description;
	private String ratingProfileId;
//	private String locationId;
	private String titlePhotoUrl;
	//private String photoCollectionId;
	private String[] photoCollection;
	
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
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

	public String getTitlePhotoUrl() {
		return titlePhotoUrl;
	}
	public void setTitlePhotoUrl(String titlePhotoUrl) {
		this.titlePhotoUrl = titlePhotoUrl;
	}
	public String[] getPhotoCollection() {
		return photoCollection;
	}
	public void setPhotoCollection(String[] photoCollection) {
		this.photoCollection = photoCollection;
	}
	
	
	
	

}
