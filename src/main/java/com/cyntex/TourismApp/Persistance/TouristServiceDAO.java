package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class TouristServiceDAO {
	
    @Autowired
    private DataSourceManager dataSourceManager;
	
	private static final String addTrouristFriendQuery="insert into tourist_service(service_title,"
			+ "service_description,"
			+ "owner_uname,"
			+ "location_id,"
			+ "title_photo_url, "
			+ "photo_collection_id, "
			+ "rating_profile_id) values (?,?,?,?,?,?,?)";
	
	
	
	@Transactional
	public void addTouristService(String serviceTitle,String serviceDescription,String ownername,String locationId,String titlePhotoUrl,String photoCollectionId,String ratingProfileId){
		
		dataSourceManager.getJdbcTemplate().update(addTrouristFriendQuery,
                new Object[] {serviceTitle,serviceDescription,ownername,locationId,titlePhotoUrl,photoCollectionId,ratingProfileId},
                new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR});
		
		
	}

}
