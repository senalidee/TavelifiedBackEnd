package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageResponseBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageResponseBean;
import com.cyntex.TourismApp.Persistance.MessageTouristGuideDAO;


@Component
public class TouristGuideServiceHandler {
	
	@Autowired
	MessageTouristGuideDAO messageTouristGuideDAO;
	
	public BaseResponse handleSendMessage(ContactTouristGuideSendMessageRequestBean contactTouristGuideSendMessageRequestBean){
		ContactTouristGuideSendMessageResponseBean response= new ContactTouristGuideSendMessageResponseBean();
		
		try{
			
			
			String firstname=contactTouristGuideSendMessageRequestBean.getFirstname();
			int serviceId=contactTouristGuideSendMessageRequestBean.getService_id();
			String username=contactTouristGuideSendMessageRequestBean.getUsername();
			String message=contactTouristGuideSendMessageRequestBean.getMessage();
			
			
			
			if(StringUtils.isEmpty(firstname) || StringUtils.isEmpty(username) || serviceId==0){
				messageTouristGuideDAO.saveMessage(serviceId,username,firstname,message);
				response.setStatus("SUCCESS");	
			}else{
				response.setStatus("FAILED :Check the payload");
				
			}
		}catch(Exception e){
			
			response.setStatus("FAILED: error occured "+e.getMessage());
		}
		return response;
			
		
	}
	
	
	public BaseResponse handleGetMessage(ContactTouristGuideGetMessageRequestBean contactTouristGuideGetMessageRequestBean){
		ContactTouristGuideGetMessageResponseBean response= new ContactTouristGuideGetMessageResponseBean();
		
		try{
			
			int serviceId=contactTouristGuideGetMessageRequestBean.getServiceId();
			String username=contactTouristGuideGetMessageRequestBean.getUsername();
			

		
			if(!(StringUtils.isEmpty(username)  || serviceId==0)){
				messageTouristGuideDAO.getMessageDetails(serviceId,username);
				response.setStatus("SUCCESS");	
			}else{
				response.setStatus("FAILED :Check the payload");
				
			}
		}catch(Exception e){
			
			response.setStatus("FAILED: error occured "+e.getMessage());
		}
		return response;		
		
		
	}

}
