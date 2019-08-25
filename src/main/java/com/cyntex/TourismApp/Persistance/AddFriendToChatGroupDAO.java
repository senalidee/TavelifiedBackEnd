package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class AddFriendToChatGroupDAO {
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	private int response;
	
	private static final String checkExistance=
	        "select participation_id from group_participant where username = ? and chat_group_id = ?";
	private  static final String addFriendRequest=
			"insert into group_participant(username,chat_group_id,added_by,avatar) values (?,?,?,?)";
	
	private  static final String addGroupCreator=
			"insert into group_participant(username,chat_group_id,is_admin,avatar) values (?,?,?,?)";
	
	
	private  static final String checkIsAdmin=
			"select count(*) as counter from group_participant where ( added_by  = ? and chat_group_id = ?)";
	
	
	@Transactional
	public int checkExistance(int chatGroupId, String username){

		 int size=dataSourceManager.getJdbcTemplate().queryForList(checkExistance,
                new Object[] {username,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER}
                ).size();

		return size;
	}
	
	@Transactional
	public void addFriend(AddFriendToChatGroupRequestBean addFriendToChatGroupRequestBean){
		int chatGroupId = addFriendToChatGroupRequestBean.getChatGroupId();
		String username=addFriendToChatGroupRequestBean.getUsername();
		String addedBy=addFriendToChatGroupRequestBean.getAddedBy();
		String avatar=addFriendToChatGroupRequestBean.getAvatar();
		
		dataSourceManager.getJdbcTemplate().update(addFriendRequest,
                new Object[] {username,chatGroupId,addedBy,avatar},
                new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR});
                
		
	}
	
	@Transactional
	public void addAdmin(int chatGroupId,String username,String avatar){
		
		dataSourceManager.getJdbcTemplate().update(addGroupCreator,
                new Object[] {username,chatGroupId,1, avatar},
                new int[]{Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.VARCHAR});
                
		
	}
	
//	@Transactional
//	public void isAdmin(String username){
//		
//		dataSourceManager.getJdbcTemplate().queryForList(addGroupCreator,
//                new Object[] {username},
//                new int[]{Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.VARCHAR});
//                
//		
//	}
	
	@Transactional
	public boolean isAdmin(String addedby, int groupId){
		
		dataSourceManager.getJdbcTemplate().query(checkIsAdmin,
                new Object[] {addedby,groupId},
                new int[]{Types.VARCHAR,Types.INTEGER},(rs,rawNo) -> response=rs.getInt("counter"));
                
		if(response == 0){return false;} else{return true;}
	}
	
	

}
