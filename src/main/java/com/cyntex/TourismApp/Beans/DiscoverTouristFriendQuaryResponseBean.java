package com.cyntex.TourismApp.Beans;

public class DiscoverTouristFriendQuaryResponseBean {
	
	public DiscoverTouristFriendQuaryResponseBean(
			String username,double averageRating) {
		
		this.averageRating = averageRating;
		this.username = username;
	}

	private double averageRating;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

}
