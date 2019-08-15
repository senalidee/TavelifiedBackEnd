package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	    public RegistrationRequestBean getUserRatingsProfile(String username) {
	    	RegistrationRequestBean queryData = (RegistrationRequestBean) dataSourceManager.getJdbcTemplate().queryForObject(
	    			ProfileFetchQuery, new Object[]{username}, new BeanPropertyRowMapper(RegistrationRequestBean.class));
	    			
//	    			dataSourceManager.getJdbcTemplate().query(
//	               ProfileFetchQuery,new Object[]{username},new int[]{Types.VARCHAR},
//	                (rs, rowNum) -> new RegistrationRequestBean(
//	                        rs.getString("fbId"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"),
//	                        rs.getString("birthday"),rs.getString("country"),rs.getString("email"),rs.getString("picture"),
//	                        (FBTokenBean)rs.getObject("fb_token"),
//	                         rs.getString("password")
//	                         )
//	        );
	        return queryData;
	    }
//		this.fbId = fbId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.gender = gender;
//		this.birthday = birthday;
//		this.country = country;
//		this.email = email;
//		this.picture = picture;
//		this.fbToken = fbToken;
//		this.password = password;
	
	
}
