package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddTouristServiceRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Logic.TouristServiceHandler;


@Service
public class TouristService {
	
	@Autowired
	private TouristServiceHandler  touristServiceHandler;
      
	public BaseResponse addTouristService(AddTouristServiceRequestBean addTouristServiceRequestBean){
		return touristServiceHandler.addTouristService(addTouristServiceRequestBean);
	} 
}
