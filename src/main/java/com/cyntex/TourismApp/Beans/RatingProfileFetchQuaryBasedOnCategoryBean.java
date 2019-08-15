package com.cyntex.TourismApp.Beans;

public class RatingProfileFetchQuaryBasedOnCategoryBean {
	public RatingProfileFetchQuaryBasedOnCategoryBean(String userName) {
		this.userName = userName;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
