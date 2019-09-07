package com.cyntex.TourismApp.Logic;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.CreateChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;
import com.cyntex.TourismApp.Persistance.ChatGroupDAO;
import com.cyntex.TourismApp.Util.DataSourceManager;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


@Component

public class ChatGroupRequestHandler {
	@Autowired
	ChatGroupDAO chatGroupDAO;
	
    @Autowired
    private DataSourceManager dataSourceManager;
    
	@Autowired
	private GroupParticipantDAO groupParticipantDAO;
	
	

	
	
	
//	String createChatGroupRequest;
	@Transactional(propagation=Propagation.REQUIRED)
	public BaseResponse createChatGroup(CreateChatGroupRequestBean createChatGroupRequestBean) throws Exception{
		BaseResponse baseResponse = new BaseResponse();
		int chatGroupId=createChatGroupRequestBean.getChatGroupId();
		String title=createChatGroupRequestBean.getGroupTitle();
		String category= createChatGroupRequestBean.getCategory();
		String createdBy=createChatGroupRequestBean.getCreatedBy();
		List<String> selectedUsers=createChatGroupRequestBean.getSelectedUsers();
		
	
			
			if(!(StringUtils.isEmpty(title) || StringUtils.isEmpty(category)|| StringUtils.isEmpty(createdBy) || chatGroupId ==0 || StringUtils.isEmpty(selectedUsers))){
		
		
			chatGroupDAO.createChatGroup(selectedUsers,chatGroupId, title, category, createdBy);
			
	        groupParticipantDAO.addAdmin(chatGroupId, createdBy);
	   	 	for (String user: selectedUsers){
	   	 		groupParticipantDAO.addFriend(user, chatGroupId, createdBy);
	   		 
	   	    }
	    		baseResponse.setStatus("SUCCESS");	
			}else{
				baseResponse.setStatus("FAILED: Check the payload again");
				
			}
			
	
	
		return baseResponse;

		
		
	}
	


}
