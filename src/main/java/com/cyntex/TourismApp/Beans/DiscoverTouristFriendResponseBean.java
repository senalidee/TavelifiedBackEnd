package com.cyntex.TourismApp.Beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cyntex.TourismApp.Logic.DiscoverTouristFriendRequestHandler;

public class DiscoverTouristFriendResponseBean extends BaseResponse{
	
	private List<RegistrationRequestBean> registrationRequestBean;

	public List<RegistrationRequestBean> getRegistrationRequestBean() {
		return registrationRequestBean;
	}

	public void setRegistrationRequestBean(
			List<RegistrationRequestBean> registrationRequestBean) {
		this.registrationRequestBean = registrationRequestBean;
	}
	

}
