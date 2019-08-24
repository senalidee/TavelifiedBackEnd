package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Logic.CreateChatGroupRequestHandler;

@Service
public class CreateChatGroupService {
	@Autowired
	private CreateChatGroupRequestHandler createChatGroupRequestHandler;
	
	public BaseResponse createChatGroup(CreateChatGroupRequestBean createChatGroupRequestBean){
		return createChatGroupRequestHandler.handle(createChatGroupRequestBean);
	}

}
