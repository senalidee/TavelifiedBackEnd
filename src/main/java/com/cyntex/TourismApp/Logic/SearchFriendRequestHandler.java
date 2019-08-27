package com.cyntex.TourismApp.Logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.SearchFriendQueryResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendResponseBean;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class SearchFriendRequestHandler {
	
	@Autowired
	UserDAO userDAO;
	
	
	public BaseResponse handle(String firstname){
		SearchFriendResponseBean response= new SearchFriendResponseBean();
		
		 List<SearchFriendQueryResponseBean> friendList;
		try{
		if(!StringUtils.isEmpty(firstname)){		
			friendList=userDAO.getSearchFriend(firstname);
			response.setStatus("SUCCESS");
			response.setSearchFriendQueryResponseBean(friendList);
			
		}else{
			response.setStatus("FAIL : username is empty");
		}
		}catch(Exception e ){
			response.setStatus("FAIL : "+e.getMessage());
			
		}
		return response;
		
		
		
	}

}
