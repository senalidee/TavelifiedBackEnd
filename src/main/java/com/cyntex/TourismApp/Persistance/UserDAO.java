package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.AuthenticatedUserBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class UserDAO {

    private static String userRetrieveQuery = "select * from user where username = ?";
    @Autowired
    private DataSourceManager dataSourceManager;

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
}
