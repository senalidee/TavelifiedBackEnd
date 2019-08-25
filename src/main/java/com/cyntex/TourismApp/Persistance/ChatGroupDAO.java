package com.cyntex.TourismApp.Persistance;

import java.sql.Types;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyntex.TourismApp.Util.DataSourceManager;


@Component
public class ChatGroupDAO {
	private static final String createChatGroupRequest=

			"insert into chat_group(chat_group_id,group_title,category,created_by,created_date) values (?,?,?,?,?)";
    @Autowired
    private DataSourceManager dataSourceManager;
    
    @Transactional
    public void createChatGroup(int groupId, String title, String category, String createdBy){
    	 dataSourceManager.getJdbcTemplate().update(createChatGroupRequest,
                 new Object[] {groupId,title,category,createdBy,new Date()},
                 new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DATE});
    	
    }

}
