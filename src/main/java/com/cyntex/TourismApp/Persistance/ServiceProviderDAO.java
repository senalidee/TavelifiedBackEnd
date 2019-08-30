package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class ServiceProviderDAO {
	
	
    @Autowired
    private DataSourceManager dataSourceManager;
    
	 private int response; 
    
	private final static String addServiceProviderRequestQuery="insert into service_providers values (?,?)";
	
	private final static String validateServiceProvider=
			"select count(*) as counter from service_providers where service_id= ? and username = ?  ";
	
	
	@Transactional
	public void addServiceProvider(int serviceId,String username){
	
		dataSourceManager.getJdbcTemplate().update(addServiceProviderRequestQuery,
                new Object[] {serviceId,username},
                new int[]{Types.INTEGER,Types.VARCHAR});
		
		
		
		
	}
	
	
	@Transactional
	public boolean validateServiceProvider( int serviceId,String username){
		
	    dataSourceManager.getJdbcTemplate().query(validateServiceProvider,
                new Object[] {serviceId, username},
                new int[]{Types.INTEGER,Types.VARCHAR},(rs,rawNo) -> response=rs.getInt("counter"));
              
	    
	    System.out.println("validateServiceProvider "+response);  
		if(response == 0){return false;} else{return true;}
	
//	public void validateServiceProvider(){
//		
//		
//	}

	}
	
}
