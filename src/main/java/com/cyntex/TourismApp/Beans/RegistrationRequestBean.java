package com.cyntex.TourismApp.Beans;

public class RegistrationRequestBean {
	public RegistrationRequestBean(){}
    public RegistrationRequestBean(String username, String firstName,
			String lastName, String gender, String country,
			String contactNumber, String pwdSalt, String password,
			String pictureLink, String locationId) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.contactNumber = contactNumber;
		this.pwdSalt = pwdSalt;
		this.password = password;
		this.pictureLink = pictureLink;
		this.locationId = locationId;
	}

	private String username;
	private String firstName;
    private String lastName;
    private String gender;
    private String country;

	private String contactNumber;
    private String pwdSalt;
    private String password;
	private String pictureLink;
    private String locationId;
    
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPwdSalt() {
		return pwdSalt;
	}
	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}
	public String getPictureLink() {
		return pictureLink;
	}
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

   

}