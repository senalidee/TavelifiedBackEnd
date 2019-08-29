package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddServiceProviderRequestBean;
import com.cyntex.TourismApp.Beans.AddTouristServiceRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Logic.TouristServiceHandler;
import com.cyntex.TourismApp.Logic.TouristServiceProvideHandler;


@Service
public class TouristService {
	
	@Autowired
	private TouristServiceHandler  touristServiceHandler;
	
	@Autowired
	private TouristServiceProvideHandler touristServiceProvideHandler;
      
	public BaseResponse addTouristService(AddTouristServiceRequestBean addTouristServiceRequestBean){
		return touristServiceHandler.addTouristService(addTouristServiceRequestBean);
	}
	
	public BaseResponse addServiceProvider(AddServiceProviderRequestBean addServiceProviderRequestBean){
		return touristServiceProvideHandler.addServiceProvider(addServiceProviderRequestBean);
		
	}
}
