package com.cyntex.TourismApp.Beans;

public class DiscoverTouristAttractionQueryResponseBean {
	private String  locationId;
	private double longitude;
	private double latitude;
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public DiscoverTouristAttractionQueryResponseBean(String locationId,
			double longitude, double latitude) {
		super();
		this.locationId = locationId;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	

}
