package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddTouristServiceRequestBean;
import com.cyntex.TourismApp.Beans.AddTouristServiceResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Persistance.TouristServiceDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class TouristServiceHandler {
	
	@Autowired
	TouristServiceDAO touristServiceDAO; 
	
	@Autowired
	UserDAO userDAO;
	
	public BaseResponse addTouristService(AddTouristServiceRequestBean addTouristServiceRequestBean){
		String addedBy=addTouristServiceRequestBean.getAddedBy();
		String locationId=addTouristServiceRequestBean.getLocationId();
		String ownername=addTouristServiceRequestBean.getOwnername();
		String photoCollectionId=addTouristServiceRequestBean.getPhotoCollectionId();
		String ratingProfileId=addTouristServiceRequestBean.getRatingProfileId();
		String serviceDescription=addTouristServiceRequestBean.getServiceDescription();
		String serviceTitle=addTouristServiceRequestBean.getServiceTitle();
		String titlePhotoUrl=addTouristServiceRequestBean.getTitlePhotoUrl();
		
		AddTouristServiceResponseBean response = new AddTouristServiceResponseBean();
		try{
			if(userDAO.isAdmin(addedBy)){
				
				if(!(StringUtils.isEmpty(locationId)||StringUtils.isEmpty(ownername)||StringUtils.isEmpty(photoCollectionId)||
						StringUtils.isEmpty(ratingProfileId)||StringUtils.isEmpty(serviceDescription)||StringUtils.isEmpty(serviceTitle)||
						StringUtils.isEmpty(titlePhotoUrl))){
					
					touristServiceDAO.addTouristService(serviceTitle,serviceDescription,ownername,locationId,titlePhotoUrl,photoCollectionId,ratingProfileId);
	
					response.setStatus("SUCCESS");	
				}else{
					
					response.setStatus("FAILED :Check the payload");
				}
					
			}else{
				response.setStatus("FAILED:you are not an admin");
			}
		}catch(Exception e){
			
			response.setStatus("FAILED: error occured "+e.getMessage());
		}
		
		return response;
	} 

}
