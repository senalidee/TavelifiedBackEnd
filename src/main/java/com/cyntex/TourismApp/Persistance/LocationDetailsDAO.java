package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class LocationDetailsDAO {
	
	
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	private static final String addLocationQuery=
			"insert into location values (?,?,?)";
	
	
	@Transactional
	public void addLocationDetails(String locationId,double lat, double lng){
		
		dataSourceManager.getJdbcTemplate().update(addLocationQuery,new Object[]{locationId,lng,lat}
		,new int[]{Types.VARCHAR,Types.DOUBLE,Types.DOUBLE});
		
		
	}

}



	
