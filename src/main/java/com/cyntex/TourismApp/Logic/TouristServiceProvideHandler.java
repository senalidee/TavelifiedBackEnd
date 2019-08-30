package com.cyntex.TourismApp.Logic;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddServiceProviderRequestBean;
import com.cyntex.TourismApp.Beans.AddServiceProviderResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Persistance.ServiceProviderDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;


@Component
public class TouristServiceProvideHandler {
	
	@Autowired
	UserDAO userDAO; 
	
	@Autowired
	ServiceProviderDAO serviceProviderDAO;
	
	
	public BaseResponse addServiceProvider(AddServiceProviderRequestBean addServiceProviderRequestBean){
		
		AddServiceProviderResponseBean response= new AddServiceProviderResponseBean();
		try{
		
			String addedBy=addServiceProviderRequestBean.getAddedBy();
			int serviceId=addServiceProviderRequestBean.getServiceId();
			String username=addServiceProviderRequestBean.getUsername();
			
			
				if(userDAO.isAdmin(addedBy)){
					if(!(StringUtils.isEmpty(username)|| serviceId==0)){
						
						serviceProviderDAO.addServiceProvider(serviceId,username);
					}else{
						response.setStatus("FAILED :Check the payload");
					}
					
					
					response.setStatus("SUCCESS");	
				}else{
					response.setStatus("FAILED : you are not an admin ");
				}
		}catch(DuplicateKeyException e){
			response.setStatus("FAILED : this service provider already exists ");
			
		}
		catch(Exception e){
			response.setStatus("FAILED: error occured "+e.getMessage());
			
		}
		return response;
	}
	

}
