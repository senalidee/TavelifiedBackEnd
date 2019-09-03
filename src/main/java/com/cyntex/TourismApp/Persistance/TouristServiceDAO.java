package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.GetTouristServiceQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class TouristServiceDAO {
	
    @Autowired
    private DataSourceManager dataSourceManager;
    
    private static final String getTouristServicesByTitleQuery="select * from tourist_service where service_title = ? ";
	
    
    private static final String getAllTouristServices="select * from tourist_service ";
    
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
                new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		
		
	}
	@Transactional
	public List<GetTouristServiceQueryResponseBean> getTouristServiceByTitle(String serviceTitle){
		List<GetTouristServiceQueryResponseBean> queryData=dataSourceManager.getJdbcTemplate().query(getTouristServicesByTitleQuery,
                new Object[] {serviceTitle},
                new int[]{Types.VARCHAR }, (rs, rowNum) -> new GetTouristServiceQueryResponseBean(
                		
                		rs.getInt("service_id"),rs.getString("service_title"),rs.getString("service_description"),
                		rs.getString("owner_uname"),rs.getString("location_id"),rs.getString("title_photo_url"),
                		rs.getString("photo_collection_id"),rs.getString("rating_profile_id")
                		
                		
                		
                		));
		
		return queryData;
		
		
	}
	@Transactional
	public List<GetTouristServiceQueryResponseBean> getAllTouristServices(){
		List<GetTouristServiceQueryResponseBean> queryData=dataSourceManager.getJdbcTemplate().query(getAllTouristServices,
            (rs, rowNum) -> new GetTouristServiceQueryResponseBean(
                		rs.getInt("service_id"),rs.getString("service_title"),rs.getString("service_description"),
                		rs.getString("owner_uname"),rs.getString("location_id"),rs.getString("title_photo_url"),
                		rs.getString("photo_collection_id"),rs.getString("rating_profile_id")
                		
                		
                		
                		));
		
		return queryData;
		
		
	}

}
