package com.cyntex.TourismApp.Beans;

import java.util.Date;



public class CreateChatGroupRequestBean {
	
	//chat_group_id	group_title	category	created_by	created_date
	
	private int chatGroupId;
	private String groupTitle;
	private String category;
	private String createdBy;
	private String avatar;
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	//private Date createdDate;
	public int getChatGroupId() {
		return chatGroupId;
	}
	public void setChatGroupId(int chatGroupId) {
		this.chatGroupId = chatGroupId;
	}
	public String getGroupTitle() {
		return groupTitle;
	}
	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
