package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class ServiceProviderDAO {
	
	
    @Autowired
    private DataSourceManager dataSourceManager;
    
	
	private final static String addServiceProviderRequestQuery="insert into service_providers values (?,?)";
	
	public void addServiceProvider(int serviceId,String username){
	
		dataSourceManager.getJdbcTemplate().update(addServiceProviderRequestQuery,
                new Object[] {serviceId,username},
                new int[]{Types.INTEGER,Types.VARCHAR});
		
		
		
		
	}

}
