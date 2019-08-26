package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Persistance.AddFriendToChatGroupDAO;
import com.cyntex.TourismApp.Persistance.ChatGroupDAO;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


@Component
public class ChatGroupRequestHandler {
	@Autowired
	ChatGroupDAO chatGroupDAO;
	
	@Autowired
	AddFriendToChatGroupDAO addFriendToChatGroup;
	
	public BaseResponse handle(CreateChatGroupRequestBean createChatGroupRequestBean){
		BaseResponse baseResponse = new BaseResponse();
		int chatGroupId=createChatGroupRequestBean.getChatGroupId();
		String title=createChatGroupRequestBean.getGroupTitle();
		String categoty= createChatGroupRequestBean.getCategory();
		String createdby=createChatGroupRequestBean.getCreatedBy();
		String avatar=createChatGroupRequestBean.getAvatar();
		try{
			chatGroupDAO.createChatGroup(
					chatGroupId, 
					title,
					categoty,
					createdby);
			
			addFriendToChatGroup.addAdmin(chatGroupId ,createdby,avatar);
			
			
			baseResponse.setStatus("SUCCESS");
			
		}catch(DataIntegrityViolationException  e){
			baseResponse.setStatus("FAILED :  chat group id is duplicated");
		
		}catch(Exception e){
			baseResponse.setStatus("FAILED :  "+e.getMessage());
		}
		return baseResponse;

		
		
	}
	


}
