package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;
import com.cyntex.TourismApp.Persistance.ChatGroupDAO;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


@Component
public class ChatGroupRequestHandler {
	@Autowired
	ChatGroupDAO chatGroupDAO;
	
	@Autowired
	GroupParticipantDAO addFriendToChatGroup;
	
	public BaseResponse createChatGroup(CreateChatGroupRequestBean createChatGroupRequestBean){
		BaseResponse baseResponse = new BaseResponse();
		int chatGroupId=createChatGroupRequestBean.getChatGroupId();
		String title=createChatGroupRequestBean.getGroupTitle();
		String categoty= createChatGroupRequestBean.getCategory();
		String createdby=createChatGroupRequestBean.getCreatedBy();
		
		try{
			
			if(!(StringUtils.isEmpty(title) || StringUtils.isEmpty(categoty)|| StringUtils.isEmpty(createdby) || chatGroupId ==0)){
			chatGroupDAO.createChatGroup(
					chatGroupId, 
					title,
					categoty,
					createdby);
			
			addFriendToChatGroup.addAdmin(chatGroupId ,createdby);
			baseResponse.setStatus("SUCCESS");
			}else{
				baseResponse.setStatus("FAILED: Check the payload again");
				
			}
			
			
			
		}catch(DataIntegrityViolationException  e){
			baseResponse.setStatus("FAILED :  chat group id is duplicated");
		
		}catch(Exception e){
			baseResponse.setStatus("FAILED :  "+e.getMessage());
		}
		return baseResponse;

		
		
	}
	


}
