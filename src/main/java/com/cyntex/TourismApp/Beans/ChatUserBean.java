package com.cyntex.TourismApp.Beans;

public class ChatUserBean {
	private String username; //Foreign key  
	private String firstname;
	private byte[] avatarStream;
	
	
	


	public ChatUserBean(String username, String firstname, byte[] avatarStream) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.avatarStream = avatarStream;
	}
	public byte[] getAvatarStream() {
		return avatarStream;
	}
	public void setAvatarStream(byte[] avatarStream) {
		this.avatarStream = avatarStream;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
	

}
