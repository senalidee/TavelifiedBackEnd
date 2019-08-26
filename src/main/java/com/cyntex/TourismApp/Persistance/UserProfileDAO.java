package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.DiscoverTouristFriendUserProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.FBTokenBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class UserProfileDAO {
	 private static final String ProfileFetchQuery
     = "select * from user where username = ?";
	 
	 
	    @Autowired
	    private DataSourceManager dataSourceManager;

	    @Transactional
	    public DiscoverTouristFriendUserProfileQueryResponseBean getUserRatingsProfile(String username) {
	    
	    	DiscoverTouristFriendUserProfileQueryResponseBean queryData = dataSourceManager.getJdbcTemplate().query(
	    			ProfileFetchQuery, new Object[]{username}, 
	                (rs, rowNum) -> new DiscoverTouristFriendUserProfileQueryResponseBean(
                    rs.getString("username"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("contact_number"),
                    rs.getString("country"),rs.getString("gender"),rs.getString("picture_link")
                    )
	                ).get(0);

	        return queryData;
	    }
	    
//		 public DiscoverTouristFriendUserProfileQueryResponseBean(String email, String firstName, String lastName, String phone,
//		           String country, String gender, String imageID){
//				 super(email,firstName,lastName,phone,country,gender,imageID);
//
//				}

	
	
}
