package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Logic.ChatGroupRequestHandler;

@Service
public class ChatGroupService {
	@Autowired
	private ChatGroupRequestHandler chatGroupRequestHandler;
	
	public BaseResponse createChatGroup(CreateChatGroupRequestBean createChatGroupRequestBean){
		return chatGroupRequestHandler.handle(createChatGroupRequestBean);
	}
   
	

}
