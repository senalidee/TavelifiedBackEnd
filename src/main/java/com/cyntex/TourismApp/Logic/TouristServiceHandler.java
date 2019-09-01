package com.cyntex.TourismApp.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddTouristServiceRequestBean;
import com.cyntex.TourismApp.Beans.AddTouristServiceResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetTouristServiceQueryResponseBean;
import com.cyntex.TourismApp.Beans.GetTouristServiceResponseBean;
import com.cyntex.TourismApp.Persistance.TouristServiceDAO;
import com.cyntex.TourismApp.Persistance.TouristServicePhotoCollectionDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;
import com.cyntex.TourismApp.Util.FSManager;


@Component
public class TouristServiceHandler {
	
	@Autowired
	TouristServiceDAO touristServiceDAO; 
	@Autowired
	TouristServicePhotoCollectionDAO touristServicePhotoCollectionDAO;
	

	
	@Autowired
	UserDAO userDAO;
	
	public BaseResponse addTouristService(AddTouristServiceRequestBean addTouristServiceRequestBean){
		String addedBy=addTouristServiceRequestBean.getAddedBy();
		String locationId=addTouristServiceRequestBean.getLocationId();
		String ownername=addTouristServiceRequestBean.getOwnername();
		//String photoCollectionId=addTouristServiceRequestBean.getPhotoCollectionId();
		String ratingProfileId=addTouristServiceRequestBean.getRatingProfileId();
		String serviceDescription=addTouristServiceRequestBean.getServiceDescription();
		String serviceTitle=addTouristServiceRequestBean.getServiceTitle();
		String titlePhoto=addTouristServiceRequestBean.getTitlePhoto();
		String[] photoCollection=addTouristServiceRequestBean.getPhotoCollection();
		
		AddTouristServiceResponseBean response = new AddTouristServiceResponseBean();
		try{
			if(userDAO.isAdmin(addedBy)){
				
				if(!(StringUtils.isEmpty(locationId)||StringUtils.isEmpty(ownername)||StringUtils.isEmpty(photoCollection)||
						StringUtils.isEmpty(ratingProfileId)||StringUtils.isEmpty(serviceDescription)||StringUtils.isEmpty(serviceTitle)||
						StringUtils.isEmpty(titlePhoto))){
					
					String titlePhotoID = UUID.randomUUID().toString();
				    FSManager.saveImage(titlePhotoID, titlePhoto);
				    
				    String photoCollectionId = UUID.randomUUID().toString();
					
					touristServiceDAO.addTouristService(serviceTitle,serviceDescription,ownername,locationId,titlePhotoID,photoCollectionId,ratingProfileId);
					for(String photo : photoCollection){
						if(!StringUtils.isEmpty(photo)){
							String photoUrl = UUID.randomUUID().toString();
							FSManager.saveImage(photoUrl, photo);
							 
							touristServicePhotoCollectionDAO.addPhotoCollection(photoCollectionId, photoUrl);
						 
						}else{response.setStatus("check the payload again");return response;}
					}
	
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
	
	
	public BaseResponse getTouristServiceByTitle(String title){
		
		
		GetTouristServiceResponseBean  response = new GetTouristServiceResponseBean();
		GetTouristServiceQueryResponseBean queryResponse;
		List<GetTouristServiceQueryResponseBean> queryResponseList= new ArrayList();
		try{
			for(GetTouristServiceQueryResponseBean queryResponseBean:touristServiceDAO.getTouristServiceByTitle(title)){
				System.out.println(" photo collection id "+ queryResponseBean.getPhotoCollectionId());
				queryResponseBean.setPhotoUrlCollection(touristServicePhotoCollectionDAO.getPhotoCollection(queryResponseBean.getPhotoCollectionId()));
				queryResponseList.add(queryResponseBean);
			}
			
			response.setGetTouristServiceQueryResponseBean(queryResponseList);
			response.setStatus("SUCCESS");	
		}catch(Exception e ){
			response.setStatus("FAILED: error occured "+e.getMessage());
			
		}
		
		return response;
	}
	
	public BaseResponse getAllTouristServices(){
		
		
		GetTouristServiceResponseBean  response = new GetTouristServiceResponseBean();
		
		try{
			response.setGetTouristServiceQueryResponseBean(touristServiceDAO.getAllTouristServices());
			response.setStatus("SUCCESS");	
		}catch(Exception e ){
			response.setStatus("FAILED: error occured "+e.getMessage());
			
		}
		
		return response;
		
		
	}

}
