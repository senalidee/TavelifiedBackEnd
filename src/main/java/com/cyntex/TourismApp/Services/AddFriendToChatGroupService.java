package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Logic.AddFriendToChatGroupRequestHandler;
@Service 


public class AddFriendToChatGroupService {
	@Autowired
	AddFriendToChatGroupRequestHandler addFriendRequestHandler;
	
	public BaseResponse addTouristFriend(AddFriendToChatGroupRequestBean addFriendRequestBean){
		return addFriendRequestHandler.handle(addFriendRequestBean);
	}

}
