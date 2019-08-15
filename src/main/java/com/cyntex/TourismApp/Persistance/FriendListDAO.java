package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class FriendListDAO {
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	private static final String addFriendRequestQuary=
			"insert into friend_list values (?,?)";
	
	@Transactional
	public void addFriend(String usernameOfRequester, String usernameOfFriend){
		dataSourceManager.getJdbcTemplate().update(addFriendRequestQuary,
                new Object[] {usernameOfRequester,usernameOfFriend},
                new int[]{Types.VARCHAR,Types.VARCHAR});
   	
		
	}

}
