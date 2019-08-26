package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.AddFriendToChatGroupResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DeleteChatGroupMemberRequestBean;
import com.cyntex.TourismApp.Persistance.AddFriendToChatGroupDAO;


@Component
public class AddFriendToChatGroupRequestHandler {
	
	@Autowired
	AddFriendToChatGroupDAO addFriendToChatGroupDAO;

	public BaseResponse handle(AddFriendToChatGroupRequestBean addFriendRequestBean){
		
		AddFriendToChatGroupResponseBean responseBean= new AddFriendToChatGroupResponseBean();
    	String username=addFriendRequestBean.getUsername();
    	int  chatGroupId=addFriendRequestBean.getChatGroupId();
    	String addedBy=addFriendRequestBean.getAddedBy();
		try{
			
			 if(addFriendToChatGroupDAO.isAdmin(addedBy,chatGroupId) &&addFriendToChatGroupDAO.checkExistance( chatGroupId, username)>0){
				 addFriendToChatGroupDAO.addFriend(addFriendRequestBean);
				 responseBean.setStatus("SUCCESS ");
		     }else{
					 responseBean.setStatus("FAILED: you are not a admin or friend is already a member of the group");
					 return responseBean;
			}
			
		}catch(Exception e ){
			responseBean.setStatus("FAILED: user cannot be added  ");
		}
		 return responseBean;
    }
	
	public BaseResponse deleteMember(DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean){
		AddFriendToChatGroupResponseBean responseBean= new AddFriendToChatGroupResponseBean();
    	String username=deleteChatGroupMemberRequestBean.getUsername();
    	int  chatGroupId=deleteChatGroupMemberRequestBean.getChatGroupId();
    	String deletedBy=deleteChatGroupMemberRequestBean.getDeletedBy();
		try{
			
			 if(addFriendToChatGroupDAO.isAdmin(deletedBy,chatGroupId) &&addFriendToChatGroupDAO.checkExistance( chatGroupId, username)>0){
				 addFriendToChatGroupDAO.deleteFriend(username , chatGroupId);
				 responseBean.setStatus("SUCCESS ");
		     }else{
					 responseBean.setStatus("FAILED: you are not a admin or friend isn't a member of the group");
					 return responseBean;
			}
			
		}catch(Exception e ){
			responseBean.setStatus("FAILED: user cannot be deleted ");
		}
		 return responseBean;
			
			
		}
		
	
}
