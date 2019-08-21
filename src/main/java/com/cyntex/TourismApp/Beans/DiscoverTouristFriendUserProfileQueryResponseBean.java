package com.cyntex.TourismApp.Beans;

public class DiscoverTouristFriendUserProfileQueryResponseBean extends RegistrationRequestBean{
	
	
	 public DiscoverTouristFriendUserProfileQueryResponseBean(String username, String firstName,
				String lastName, String gender, String country,
				String contactNumber, String pwdSalt, String password,
				String pictureLink, String locationId) {
		 super(username,firstName,lastName,gender,country,contactNumber,pwdSalt,password,pictureLink,locationId);

		}

	    
}
