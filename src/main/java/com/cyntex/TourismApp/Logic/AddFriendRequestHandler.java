package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddFriendRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Persistance.FriendListDAO;




@Component
public class AddFriendRequestHandler {
	
	@Autowired
	FriendListDAO friendListDAO;
	
	public BaseResponse handle(AddFriendRequestBean addFriendRequestBean){
		String username=addFriendRequestBean.getUserName();
		String friendname=addFriendRequestBean.getFriendName();
		
		BaseResponse response =new BaseResponse();
		try{
			if(!(StringUtils.isEmpty(username) || StringUtils.isEmpty(friendname))){
			friendListDAO.addFriend(username, friendname);
			response.setStatus("Success");
			
			}else{
				response.setStatus("Check the payload again");
			}
			
			
			
			
		}catch(DataIntegrityViolationException  e){
			response.setStatus("FAILED : "+"Friend is already added");
			
		}
		
	    catch(Exception e){
			
			response.setStatus("FAILED : "+e.getMessage());
			
		}
		
		return response;
		
		
		
	}
}
