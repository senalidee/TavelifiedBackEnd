package com.cyntex.TourismApp.Logic;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.AddFriendToChatGroupDAO;
import com.cyntex.TourismApp.Persistance.MessageDAO;


@Component
public class MesssageServiceHandler {
	
	@Autowired
	private MessageDAO messageDAO;
	
	@Autowired
	private AddFriendToChatGroupDAO addFriendToChatGroupDAO;
	
	public BaseResponse handleSendMessage(SendMessageRequestBean requestBean){
		
		SendMessageResponseBean responseBean = new SendMessageResponseBean();
		try{
	
		 String username=requestBean.getUsername();
	     int chatGroupId=requestBean.getGroupId();
		 String message=requestBean.getMessage();
	    
		 if(addFriendToChatGroupDAO.checkExistance( chatGroupId, username)>0){
		    messageDAO.saveMessage(chatGroupId,username,message);
		 }else{
			 responseBean.setStatus("FAILED: user is not in the group ");
			 return responseBean;
		 }
		 

		 responseBean.setStatus("SUCCESS");
     } catch (Exception e) {
    	 responseBean.setStatus("FAILED: error occured "+e.getMessage());
			
	}
		return responseBean;
		
	}
	
	public BaseResponse handleGetMessage(int chatGroupId){
		
		GetMessageResponseBean responseBean = new GetMessageResponseBean();
		try{
		//	int chatGroupId=getMessageRequestBean.getChatGroupId();
		 List<SendMessageQueryResponsBean> messageReponseList=messageDAO.getMessageDetails(chatGroupId);
		 responseBean.setMessageReponseList(messageReponseList);
		
		 responseBean.setStatus("SUCCESS");
	     } catch (Exception e) {
	    	 responseBean.setStatus("FAILED: error occured "+e.getMessage());
				
		}
			return responseBean;
			
		}
	

}
