package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Persistance.ChatGroupDAO;

@Component
public class CreateChatGroupRequestHandler {
	@Autowired
	ChatGroupDAO chatGroupDAO;
	
	public BaseResponse handle(CreateChatGroupRequestBean createChatGroupRequestBean){
		BaseResponse baseResponse = new BaseResponse();
		try{
			chatGroupDAO.createChatGroup(
					createChatGroupRequestBean.getChatGroupId(), 
					createChatGroupRequestBean.getGroupTitle(),
					createChatGroupRequestBean.getCategory(),
					createChatGroupRequestBean.getCreatedBy());
			
			baseResponse.setStatus("SUCCESS");
		}catch(Exception e){
			baseResponse.setStatus("FAILED :  "+e.getMessage());
		}
		return baseResponse;

		
		
	}

}
