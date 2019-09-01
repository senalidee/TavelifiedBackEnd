package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.AddTouristAttractionRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionRequestBean;
import com.cyntex.TourismApp.Logic.TouristAttractionRequestHandler;

@Service
public class TouristAttractionService {
	@Autowired
	TouristAttractionRequestHandler touristAttractionRequestHandler;
	
	public BaseResponse discoverTouristAttraction(DiscoverTouristAttractionRequestBean discoverTouristAttractionRequestBean){
		return touristAttractionRequestHandler.getTouristAttraction(discoverTouristAttractionRequestBean);
	}

	public BaseResponse addTouristAttraction(AddTouristAttractionRequestBean addTouristAttractionRequestBean ){
		return touristAttractionRequestHandler.addTouristAttraction(addTouristAttractionRequestBean);
		
	}
}
