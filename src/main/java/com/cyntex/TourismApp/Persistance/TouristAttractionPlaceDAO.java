package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.subst.Token.Type;

import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionPlaceQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;

@Component
public class TouristAttractionPlaceDAO {
	
	private static final String touristAttractionPlacesFetchQuery=
			"select attraction_name,description,rating_profile_id,location_id,title_photo_url,photo_collection_id from tourist_attaraction where location_id= ?";
	
	
    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public DiscoverTouristAttractionPlaceQueryResponseBean getLocationDetails(String  locationId ) {
 
    	DiscoverTouristAttractionPlaceQueryResponseBean queryData = dataSourceManager.getJdbcTemplate().query(
    			touristAttractionPlacesFetchQuery, new Object[]{locationId}, new int[]{Types.VARCHAR},
                (rs, rowNum) -> new DiscoverTouristAttractionPlaceQueryResponseBean(rs.getString("attraction_name"),rs.getString("description"),rs.getString("rating_profile_id"),
                		rs.getString("location_id"),rs.getString("title_photo_url"),rs.getString("photo_collection_id"))).get(0);
    	return queryData;
  }
}
