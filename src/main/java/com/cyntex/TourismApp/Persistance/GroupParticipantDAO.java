package com.cyntex.TourismApp.Persistance;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Beans.AddFriendToChatGroupRequestBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Util.DataSourceManager;



@Component
public class GroupParticipantDAO {
	
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//	
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	private int response;
	
	private static final String checkExistance=
	        "select count(*) as counter from group_participant where username = ? and chat_group_id = ?";
	private  static final String addFriendRequest=
			"insert into group_participant(username,chat_group_id,added_by) values (?,?,?)";
	
	private  static final String deleteFriendRequest=
			"delete from group_participant where  username = ? and chat_group_id = ?";
	
	private  static final String addGroupCreator=
			"insert into group_participant(username,chat_group_id,is_admin) values (?,?,?)";
		
	private  static final String checkIsAdmin=
			"select count(*) as counter from group_participant where username  = ? and chat_group_id = ? and is_admin = '1'  ";
	
	private static final String makeAdmin=
			"update group_participant set is_admin= '1' where username = ? and chat_group_id = ?";
			
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Transactional
	public void makeAdmin(int chatGroupId, String username){
		
		jdbcTemplate.update(makeAdmin,
                new Object[] {username,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER});
		
		
	}		
		
	@Transactional
	public boolean checkExistance(int chatGroupId, String username){
	
		jdbcTemplate.query(checkExistance,
                new Object[] {username,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER},(rs,rawNo) ->response= rs.getInt("counter"));
		   
//	System.out.println("checkExistance "+response);        
		if(response == 0){return false;} else{return true;}
	}
//		 int size=dataSourceManager.getJdbcTemplate().queryForList(checkExistance,
//                new Object[] {username,chatGroupId},
//                new int[]{Types.VARCHAR,Types.INTEGER}
//                ).size();

//		return size;
	
	

	
	public void addFriend(String username,int chatGroupId,String addedBy){

		
		jdbcTemplate.update(addFriendRequest,
                new Object[] {username,chatGroupId,addedBy},
                new int[]{Types.VARCHAR,Types.INTEGER,Types.VARCHAR});
                
	}

	public void addAdmin(int chatGroupId,String username){
		
		jdbcTemplate.update(addGroupCreator,
                new Object[] {username,chatGroupId,1},
                new int[]{Types.INTEGER,Types.INTEGER,Types.INTEGER});
                
		
	}
//	public void addFriendAtGroupCreation(String username,int chatGroupId,String addedBy){
////		int chatGroupId = addFriendToChatGroupRequestBean.getChatGroupId();
////		String username=addFriendToChatGroupRequestBean.getUsername();
////		String addedBy=addFriendToChatGroupRequestBean.getAddedBy();
////		String avatar=addFriendToChatGroupRequestBean.getAvatar();
//		
//		dataSourceManager.getJdbcTemplate().update(addFriendRequest,
//                new Object[] {username,chatGroupId,addedBy},
//                new int[]{Types.VARCHAR,Types.INTEGER,Types.VARCHAR});
//                
//	//	(username,chat_group_id,added_by,avatar) values (?,?,?,?)
//	}
	
	@Transactional
	public void deleteFriend(String username , int chatGroupId){
		
		dataSourceManager.getJdbcTemplate().update(deleteFriendRequest,
                new Object[] {username, chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER});
                
		
	}
	
	@Transactional
	public boolean isAdmin(String addedBy, int chatGroupId){
		
	    dataSourceManager.getJdbcTemplate().query(checkIsAdmin,
                new Object[] {addedBy,chatGroupId},
                new int[]{Types.VARCHAR,Types.INTEGER},(rs,rawNo) -> response=rs.getInt("counter"));
              
	    
	    System.out.println("isAdmin "+response);  
		if(response == 0){return false;} else{return true;}
	}
	
	

}
