package com.cyntex.TourismApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.MakeAdminRequestBean;
import com.cyntex.TourismApp.Logic.MakeAdminRequestHandler;


@Service
public class MakeAdminService {
	
	@Autowired
	MakeAdminRequestHandler makeAdminRequestHandler;
	
	public BaseResponse makeAdmin(MakeAdminRequestBean makeAdminRequestBean){
		return makeAdminRequestHandler.handle(makeAdminRequestBean);
		
	}
	
}
