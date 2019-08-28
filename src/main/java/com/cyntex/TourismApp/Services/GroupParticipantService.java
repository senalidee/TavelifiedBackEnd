package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Logic.GroupParticipantRequestHandler;
@Service 


public class GroupParticipantService {
	@Autowired
	GroupParticipantRequestHandler addFriendRequestHandler;
	
	public BaseResponse addFriend(AddFriendToChatGroupRequestBean addFriendRequestBean){
		return addFriendRequestHandler.addMember(addFriendRequestBean);
	}
	
	public BaseResponse deleteMember(DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean){
		
		return addFriendRequestHandler.deleteMember(deleteChatGroupMemberRequestBean);
	}

}
