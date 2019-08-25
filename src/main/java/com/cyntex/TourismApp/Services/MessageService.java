package com.cyntex.TourismApp.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetMessageRequestBean;
import com.cyntex.TourismApp.Beans.SendMessageRequestBean;
import com.cyntex.TourismApp.Logic.MesssageServiceHandler;


@Service
public class MessageService {
	
	@Autowired
	private MesssageServiceHandler messsageServiceHandler;
	

	public BaseResponse sendMessage(SendMessageRequestBean requestBean){
		return messsageServiceHandler.handleSendMessage(requestBean);
	}

	public BaseResponse getMessage(int chatId){
		return messsageServiceHandler.handleGetMessage(chatId);
	}


}
