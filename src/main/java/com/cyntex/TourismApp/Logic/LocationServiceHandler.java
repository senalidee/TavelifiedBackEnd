package com.cyntex.TourismApp.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddLocationRequestBean;
import com.cyntex.TourismApp.Beans.AddLocationResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Persistance.LocationDetailsDAO;


@Component
public class LocationServiceHandler {
//	
//	@Autowired
//	LocationDetailsDAO 	locationDetailsDAO;
//	
//	
//	
//	
//	
//	
//	public BaseResponse addLocationDetails(AddLocationRequestBean addLocationRequestBean){
//		String locationId=addLocationRequestBean.getLocationId();
//		double lat=addLocationRequestBean.getLat();
//		double lng=addLocationRequestBean.getLng();
//		AddLocationResponseBean response= new AddLocationResponseBean();
//		try{
//		
//				
//			if(!(StringUtils.isEmpty(locationId))){
//				
//				locationDetailsDAO.addLocationDetails(locationId,lat,lng);
//
//				response.setStatus("SUCCESS");	
//			}else{
//				
//				response.setStatus("FAILED :Check the payload");
//			}
//			
//		
//			
//		}catch(DataIntegrityViolationException  e){
//			response.setStatus("FAILED : location already exists");
//			
//		}catch(Exception e){
//			
//			response.setStatus("FAILED: error occured "+e.getMessage());
//		}
//		
//		
//		return response;
//	}

}
