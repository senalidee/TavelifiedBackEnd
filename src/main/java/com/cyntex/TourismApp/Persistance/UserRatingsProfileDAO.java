package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.DiscoverTouristFriendQuaryResponseBean;
import com.cyntex.TourismApp.Beans.RatingProfileFetchQuaryBasedOnCategoryBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Util.DataSourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserRatingsProfileDAO {
    private static final String ratingsProfileFetchQuery
            = "select * from user_rating_profile where username = ?";
    
//    private static final String ratingProfileFetchQuaryBasedOnCategory
//    		= "select distinct username from user_rating_profile where category = ? and username != ?";
//    
    private static final String findAverageRatingValueFetchQuery
    		= "select username,avg(rating) as average_rating from user_rating_profile where category = ? and username != ? group by username ";
    
   

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public List<RatingsProfileQueryResponseBean> getUserRatingsProfile(String username) {
        List<RatingsProfileQueryResponseBean> queryData = dataSourceManager.getJdbcTemplate().query(
                ratingsProfileFetchQuery,new Object[]{username},new int[]{Types.VARCHAR},
                (rs, rowNum) -> new RatingsProfileQueryResponseBean(
                        rs.getString("category"), rs.getDouble("rating"))
        );
        return queryData;
    }
    
//    @Transactional
//    public List<RatingProfileFetchQuaryBasedOnCategoryBean> getUserName(String cateory, String username){
//    	List<RatingProfileFetchQuaryBasedOnCategoryBean> queryData= dataSourceManager.getJdbcTemplate().query(
//    			ratingProfileFetchQuaryBasedOnCategory,new Object[]{cateory, username},new int[]{Types.VARCHAR},
//                (rs, rowNum) -> new RatingProfileFetchQuaryBasedOnCategoryBean(
//                        rs.getString("username"))
//        );
//    	return queryData;
//    	
//    	
//    }
    
    @Transactional
    public List<DiscoverTouristFriendQuaryResponseBean> getAverageRating(String category, String username){
    	// average rating value
    	List<DiscoverTouristFriendQuaryResponseBean> queryData= dataSourceManager.getJdbcTemplate().query(
    			findAverageRatingValueFetchQuery,new Object[]{category, username},new int[]{Types.VARCHAR,Types.VARCHAR},
                (rs, rowNum) -> new DiscoverTouristFriendQuaryResponseBean(
                        rs.getString("username"),rs.getDouble("average_rating"))
        );
    	return queryData;
    
    }
}
