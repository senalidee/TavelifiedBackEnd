package com.cyntex.TourismApp.Persistance;

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

    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public List<RatingsProfileQueryResponseBean> getUserRatingsProfile(String username) {
        List<RatingsProfileQueryResponseBean> queryData = dataSourceManager.getJdbcTemplate().query(
                ratingsProfileFetchQuery,
                new Object[]{username},
                new int[]{Types.VARCHAR},
                (rs, rowNum) -> new RatingsProfileQueryResponseBean(
                        rs.getString("category"), rs.getInt("rating"))
        );
        return queryData;
    }
}
