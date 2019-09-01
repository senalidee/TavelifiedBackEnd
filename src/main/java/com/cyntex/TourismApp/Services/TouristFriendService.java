package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRequestBean;
import com.cyntex.TourismApp.Logic.DiscoverTouristFriendRequestHandler;
import com.cyntex.TourismApp.Logic.SearchFriendRequestHandler;

@Service
public class TouristFriendService {
	@Autowired
	private DiscoverTouristFriendRequestHandler discoverTouristFriendRequestHandler;
	
	@Autowired
	private SearchFriendRequestHandler searchFriendRequestHandler;
	
	public BaseResponse discoverTouristFriend(DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean){
		return discoverTouristFriendRequestHandler.handle(discoverTouristFriendRequestBean);
	}
	
	
	public BaseResponse searchFriend(String fullname){
		return searchFriendRequestHandler.handle(fullname);
		
	}
	

}
