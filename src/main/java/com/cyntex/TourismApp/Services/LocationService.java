package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddLocationRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Logic.LocationServiceHandler;



@Service
public class LocationService {
	

	@Autowired
	LocationServiceHandler locationServiceHandler;
		
     public BaseResponse handleLocationDetails(AddLocationRequestBean addLocationRequestBean ){
    	 
    	 return locationServiceHandler.handleLocationDetails(addLocationRequestBean);
     }
}
