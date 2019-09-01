package com.cyntex.TourismApp.Beans;

import java.util.List;

public class DiscoverTouristAttractionPlaceQueryResponseBean {
	private int attaractionId;
	private String attractionName;
	private String description;
	private String ratingProfileId;
	private String locationId;
	private String titlePhotoUrl;
	private String photoCollectionId;	
	private List<String> photoUrlCollection;
	


	public DiscoverTouristAttractionPlaceQueryResponseBean(int attaractionId,
			String attractionName, String description, String ratingProfileId,
			String locationId, String titlePhotoUrl,
			String photoCollectionId) {
		super();
		this.attaractionId = attaractionId;
		this.attractionName = attractionName;
		this.description = description;
		this.ratingProfileId = ratingProfileId;
		this.locationId = locationId;
		this.titlePhotoUrl = titlePhotoUrl;
		this.photoCollectionId = photoCollectionId;
	
	}


	public String getPhotoCollectionId() {
		return photoCollectionId;
	}


	public void setPhoto_collection_id(String photoCollectionId) {
		this.photoCollectionId = photoCollectionId;
	}


	public int getAttaractionId() {
		return attaractionId;
	}


	public void setAttaractionId(int attaractionId) {
		this.attaractionId = attaractionId;
	}


	public List<String> getPhotoUrlCollection() {
		return photoUrlCollection;
	}


	public void setPhotoUrlCollection(List<String> photoUrlCollection) {
		this.photoUrlCollection = photoUrlCollection;
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


	

}
