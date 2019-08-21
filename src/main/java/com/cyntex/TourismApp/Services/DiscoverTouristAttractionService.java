package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionRequestBean;
import com.cyntex.TourismApp.Logic.DiscoverTouristAttractionRequestHandler;

@Service
public class DiscoverTouristAttractionService {
	@Autowired
	DiscoverTouristAttractionRequestHandler discoverTouristAttractionRequestHandler;
	
	public BaseResponse discoverTouristAttraction(DiscoverTouristAttractionRequestBean discoverTouristAttractionRequestBean){
		return discoverTouristAttractionRequestHandler.handle(discoverTouristAttractionRequestBean);
	}

}
