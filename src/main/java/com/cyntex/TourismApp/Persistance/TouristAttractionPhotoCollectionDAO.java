package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class TouristAttractionPhotoCollectionDAO {
	
    @Autowired
    private DataSourceManager dataSourceManager;
    
    private String[] photoCollection;
    
    
    private final static String addPhotoQuery="insert into tourist_attraction_photo_collection values (?,?)";
	
    private final static String getPhotoQuery="select * from tourist_attraction_photo_collection where photo_collection_id = ? ";
    
	public void addPhotoCollection(String photoCollectionId, String photoUrl){
		
		dataSourceManager.getJdbcTemplate().update(addPhotoQuery,new Object[]{photoCollectionId,photoUrl},
				new int[]{Types.VARCHAR,Types.VARCHAR});
		
	}
	
	public List<String> getPhotoCollection(String photoCollectionId){

		List<String> photoCollection=dataSourceManager.getJdbcTemplate().query(getPhotoQuery,new Object[]{photoCollectionId},
				new int[]{Types.VARCHAR}, (rs, rowNum)-> rs.getString("photo_url"));
		
	
		return photoCollection;
	}
    

}
