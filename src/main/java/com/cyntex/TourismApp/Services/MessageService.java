package com.cyntex.TourismApp.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageRequestBean;
import com.cyntex.TourismApp.Beans.GetMessageRequestBean;
import com.cyntex.TourismApp.Beans.SendMessageRequestBean;
import com.cyntex.TourismApp.Logic.MesssageServiceHandler;
import com.cyntex.TourismApp.Logic.TouristGuideServiceHandler;


@Service
public class MessageService {
	
	@Autowired
	private MesssageServiceHandler messsageServiceHandler;
	
	@Autowired
	private TouristGuideServiceHandler touristGuideServiceHandler;
	

	public BaseResponse sendMessage(SendMessageRequestBean requestBean){
		return messsageServiceHandler.handleSendMessage(requestBean);
	}

	public BaseResponse getMessage(int chatId){
		return messsageServiceHandler.handleGetMessage(chatId);
	}
	
	public BaseResponse sendMessageToTouristGuide(ContactTouristGuideSendMessageRequestBean requestBean){
		return touristGuideServiceHandler.handleSendMessage(requestBean);
	}

	
	public BaseResponse getMessageFromTouristGuide(ContactTouristGuideGetMessageRequestBean requestBean){
		return touristGuideServiceHandler.handleGetMessage(requestBean);
	}



}
