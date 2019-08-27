package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.AuthenticatedUserBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendUserProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendQueryResponseBean;
import com.cyntex.TourismApp.Beans.SearchFriendResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserDAO {
	  @Autowired
	    private DataSourceManager dataSourceManager;



    private static final String userRetrieveQuery = "select * from user where username = ?";
    
    private static final String userRetreveRequestQuery= "select * from user where first_name like ?";
    
   
    
	 
  
    @Transactional
    public List<AuthenticatedUserBean> getAuthenticatedUser(String username) {
        List<AuthenticatedUserBean> queryData = dataSourceManager.getJdbcTemplate().query(
                userRetrieveQuery,
                new Object[]{username},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new AuthenticatedUserBean(
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_number"),
                        rs.getString("country"),
                        rs.getString("gender"),
                        rs.getString("picture_link"),
                        rs.getString("password"),
                        rs.getString("pwd_salt"),
                        rs.getInt("is_admin"))
        );
        return queryData;
    }
    

    @Transactional
    public DiscoverTouristFriendUserProfileQueryResponseBean getUserRatingsProfile(String username) {
    
    	DiscoverTouristFriendUserProfileQueryResponseBean queryData = dataSourceManager.getJdbcTemplate().query(
    			userRetrieveQuery, new Object[]{username}, 
                (rs, rowNum) -> new DiscoverTouristFriendUserProfileQueryResponseBean(
                rs.getString("username"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("contact_number"),
                rs.getString("country"),rs.getString("gender"),rs.getString("picture_link")
                )
                ).get(0);

        return queryData;
    }
    
    
    @Transactional
    public List<SearchFriendQueryResponseBean> getSearchFriend(String firstname){
    //	System.out.print(firstname);
    
    List<SearchFriendQueryResponseBean> queryData=dataSourceManager.getJdbcTemplate().query(
    		userRetreveRequestQuery, new Object[]{firstname+"%"}, new int[]{Types.VARCHAR},
            (rs, rowNum) -> new SearchFriendQueryResponseBean(
            rs.getString("username"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("contact_number"),
            rs.getString("country"),rs.getString("gender"),rs.getString("picture_link")
            )
            );
 //   System.out.print(queryData.size());
       return queryData;
            
    }
}
