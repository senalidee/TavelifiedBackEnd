package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddFriendRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Logic.AddFriendRequestHandler;

@Service
public class AddtouristFriendService {
	@Autowired
	AddFriendRequestHandler addFriendRequestHandler;
	
	public BaseResponse addTouristFriend(AddFriendRequestBean addFriendRequestBean){
		return addFriendRequestHandler.handle(addFriendRequestBean);
	}

}
