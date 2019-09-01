package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class LocationDetailsDAO {
	
	
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	private static final String addLocationQuery=
			"insert into location values (?,?,?)";
	
	
	public static final String locationDetailFetcQuery=
			"select * from location";
	
	@Transactional
	public void addLocationDetails(String locationId,double lat, double lng){
		
		dataSourceManager.getJdbcTemplate().update(addLocationQuery,new Object[]{locationId,lng,lat}
		,new int[]{Types.VARCHAR,Types.DOUBLE,Types.DOUBLE});
		
		
	}

	


    @Transactional
    public List<DiscoverTouristAttractionQueryResponseBean> getUserRatingsProfile() {

    	List<DiscoverTouristAttractionQueryResponseBean> queryData = dataSourceManager.getJdbcTemplate().query(
    			locationDetailFetcQuery, 
                (rs, rowNum) -> new DiscoverTouristAttractionQueryResponseBean( rs.getString("location_id"),rs.getDouble("lng"),rs.getDouble("lat")));
	
    	return queryData;
    }

}



	
