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
	
	private int response;
	
	private static final String addFriendRequestQuery=
			"insert into friend_list values (?,?)";
	private static final String checkRecordRequestQuery=
			"select count(*) as counter from friend_list where username = ? and username_of_friend = ?";
	
	@Transactional
	public void addFriend(String usernameOfRequester, String usernameOfFriend){
		dataSourceManager.getJdbcTemplate().update(addFriendRequestQuery,
                new Object[] {usernameOfRequester,usernameOfFriend},
                new int[]{Types.VARCHAR,Types.VARCHAR});
		dataSourceManager.getJdbcTemplate().update(addFriendRequestQuery,
                new Object[] {usernameOfFriend,usernameOfRequester},
                new int[]{Types.VARCHAR,Types.VARCHAR});
   	
		
	}
	
	@Transactional
	public boolean isRecordAlreadyExists(String usernameOfRequester, String usernameOfFriend){
		dataSourceManager.getJdbcTemplate().query(checkRecordRequestQuery,
                new Object[] {usernameOfRequester,usernameOfFriend},
                new int[]{Types.VARCHAR,Types.VARCHAR},(rs,rawNo) -> response=rs.getInt("counter"));
		
		if(response == 0){return false;} else{return true;}
		
	}

}
