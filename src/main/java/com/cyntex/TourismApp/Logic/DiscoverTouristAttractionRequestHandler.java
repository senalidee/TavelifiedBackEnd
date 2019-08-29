package com.cyntex.TourismApp.Logic;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionPlaceQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionPlaceResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionRequestBean;
import com.cyntex.TourismApp.Persistance.TouristAttractionDAO;
import com.cyntex.TourismApp.Persistance.TouristAttractionPlaceDAO;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;


@Component
public class DiscoverTouristAttractionRequestHandler {
	@Autowired
	TouristAttractionDAO  touristAttractionDAO;
	
	@Autowired
	TouristAttractionPlaceDAO touristAttractionPlaceDAO;
	
	
	
	
	public BaseResponse handle(DiscoverTouristAttractionRequestBean discoverTouristAttractionRequestBean){
		List<DiscoverTouristAttractionPlaceQueryResponseBean> discoverTouristAttractionResponseBeanList= new ArrayList<DiscoverTouristAttractionPlaceQueryResponseBean>();
		DiscoverTouristAttractionPlaceQueryResponseBean discoverTouristAttractionPlaceQueryResponseBean;
		DiscoverTouristAttractionPlaceResponseBean responseBean= new DiscoverTouristAttractionPlaceResponseBean();
		try{
			List<DiscoverTouristAttractionQueryResponseBean> discoverTouristAttractionQuaryResponseBeanList =touristAttractionDAO.getUserRatingsProfile();
			
			double currentLongitude=discoverTouristAttractionRequestBean.getLongitude();
			double currentLatitude=discoverTouristAttractionRequestBean.getLatitude();
			if(!(StringUtils.isEmpty(currentLongitude) || StringUtils.isEmpty(currentLatitude))){
			for(DiscoverTouristAttractionQueryResponseBean discoverTouristAttractionQueryResponseBean:discoverTouristAttractionQuaryResponseBeanList){
				double longitude =discoverTouristAttractionQueryResponseBean.getLongitude();
				double latitude =discoverTouristAttractionQueryResponseBean.getLatitude();
		
				if(isAttractivePlace(currentLatitude,currentLongitude,latitude,longitude)){
					discoverTouristAttractionPlaceQueryResponseBean=touristAttractionPlaceDAO.getLocationDetails(discoverTouristAttractionQueryResponseBean.getLocationId());
					discoverTouristAttractionResponseBeanList.add(discoverTouristAttractionPlaceQueryResponseBean);
				}if(discoverTouristAttractionResponseBeanList.size()>=10){break;}
			}
			responseBean.setStatus("SUCCESS");
			
			responseBean.setDiscoverTouristAttractionPlaceQueryResponseBean(discoverTouristAttractionResponseBeanList);
			}else{
				responseBean.setStatus("Check the payload");	
			}
		
			responseBean.setStatus("SUCCESS");
		}catch(Exception e){
			responseBean.setStatus("FAIL "+e.getMessage());
			
	
			
		}
		
		return responseBean;
	}
	public boolean isAttractivePlace(double lat1,double long1,double lat2,double long2){
		if(HaversineInM(lat1,long1,lat2,long2)<100){
			return true;
		}else{return false;}
		
	}
    static final double _eQuatorialEarthRadius = 6371D;
    static final double _d2r = (Math.PI / 180D);

    public  double HaversineInM(double lat1, double long1, double lat2, double long2) {
    	 
        return HaversineInKM(lat1, long1, lat2, long2);
    }

    public  double HaversineInKM(double lat1, double long1, double lat2, double long2) {
    	
    	double dlat = (lat2 - lat1) * _d2r;
    	double dlong = (long2 - long1) * _d2r;
    	
    	lat1=lat1*_d2r;
    	lat2=lat2*_d2r;
       
        double a =Math.sin(dlat / 2)*Math.sin(dlat / 2) + 
        		Math.sin(dlong/2) * Math.sin(dlong/2)
                * Math.cos(lat1)*Math.cos(lat2);
        double c = 2* Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = _eQuatorialEarthRadius * c;
        
       
        System.out.println("distance "+ Math.abs(distance));
        return Math.abs(distance);
    }

}
