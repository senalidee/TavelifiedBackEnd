package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRequestBean;
import com.cyntex.TourismApp.Logic.DiscoverTouristFriendRequestHandler;

@Service
public class DiscoverTouristFriendService {
	@Autowired
	private DiscoverTouristFriendRequestHandler discoverTouristFriendRequestHandler;
	
	public BaseResponse discoverTouristFriend(DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean){
		return discoverTouristFriendRequestHandler.handle(discoverTouristFriendRequestBean);
	}

}
