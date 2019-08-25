package com.cyntex.TourismApp.Beans;

public class ChatUserBean {
	private String username; //Foreign key  
	private String avatar;
	
	
	
	public ChatUserBean( String username, String avatar) {

		this.username = username;
		this.avatar = avatar;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	

}
