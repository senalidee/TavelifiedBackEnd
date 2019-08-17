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
	    	System.out.println("Start");
	    	RegistrationRequestBean queryData = dataSourceManager.getJdbcTemplate().query(
	    			ProfileFetchQuery, new Object[]{username}, 
	                (rs, rowNum) -> new RegistrationRequestBean(
                    rs.getString("username"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("gender"),
                    rs.getString("country"),rs.getString("contact_number"),rs.getString("pwd_salt"),
                     rs.getString("password"), rs.getString("picture_link"),rs.getString("location_id")
                    )
	                ).get(0);

	        return queryData;
	    }

	
	
}
