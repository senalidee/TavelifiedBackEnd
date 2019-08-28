package com.cyntex.TourismApp.Logic;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.MakeAdminRequestBean;
import com.cyntex.TourismApp.Beans.MakeAdminResponseBean;
import com.cyntex.TourismApp.Persistance.GroupParticipantDAO;


@Component
public class MakeAdminRequestHandler {
	
	@Autowired
	GroupParticipantDAO groupParticipantDAO;
	
	MakeAdminResponseBean response= new MakeAdminResponseBean();
	
	public BaseResponse handle(MakeAdminRequestBean makeAdminRequestBean){
	
		int chatGroupId=makeAdminRequestBean.getGroupId();
		String username=makeAdminRequestBean.getUsername();
		String adminname=makeAdminRequestBean.getAdminname();
		try{
		if(groupParticipantDAO.isAdmin(adminname, chatGroupId) && groupParticipantDAO.checkExistance( chatGroupId, username)){
			groupParticipantDAO.makeAdmin(chatGroupId, username);
			
			response.setStatus("making admin is successful");
			
		}else{response.setStatus("you are not an admin or user is not in the group: making admin is unsuccessful");
		
		}
		  return response;
		}catch(Exception e){
			response.setStatus("making admin is unsuccessful");
			 return response;
		}
		
//		catch(SQLIntegrityConstraintViolationException e){
//			response.setStatus("y");
//			
//		}
	}
	
}
