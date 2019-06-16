package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;


@Component
public class RegistrationDAO {
    private static String registerQuery = "insert into user " +
            "(username, first_name, last_name, gender, country, contact_number, email_address, birthday, rating_profile_id," +
            "picture_link, fb_token, password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public void addNewRecord(String userName,String firstName,String lastName, String gender, String country,
                             String contactNumber, String emailAddress, String birthday, String ratingProfileId,
                             String pictureLink, String fbToken, String password){
        dataSourceManager.getJdbcTemplate().update(registerQuery,
                new Object[] {userName,firstName,lastName,gender,country,contactNumber,emailAddress,
        birthday, ratingProfileId,pictureLink,fbToken, password},
                new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
                Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR});
    }
}
