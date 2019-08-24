package com.cyntex.TourismApp.Persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionQueryResponseBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class TouristAttractionDAO {
	public static final String locationDetailFetcQuery="select * from location";
	

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public List<DiscoverTouristAttractionQueryResponseBean> getUserRatingsProfile() {

    	List<DiscoverTouristAttractionQueryResponseBean> queryData = dataSourceManager.getJdbcTemplate().query(
    			locationDetailFetcQuery, 
                (rs, rowNum) -> new DiscoverTouristAttractionQueryResponseBean(rs.getString("location_id"),rs.getDouble("lng"),rs.getDouble("lat")));
	
    	return queryData;
    }
}
