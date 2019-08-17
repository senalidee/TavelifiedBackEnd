package com.cyntex.TourismApp.Controller;


import java.util.List;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Logic.AddFriendRequestHandler;
import com.cyntex.TourismApp.Logic.CreateChatGroupRequestHandler;
import com.cyntex.TourismApp.Logic.DiscoverTouristFriendRequestHandler;
import com.cyntex.TourismApp.Logic.FoodRequestHandler;
import com.cyntex.TourismApp.Logic.RatingProfileRequestHandler;
import com.cyntex.TourismApp.Logic.TestRequestHandler;
import com.cyntex.TourismApp.Services.AddtouristFriendService;
import com.cyntex.TourismApp.Services.CreateChatGroupService;
import com.cyntex.TourismApp.Services.DiscoverTouristAttractionService;
import com.cyntex.TourismApp.Services.DiscoverTouristFriendService;
import com.cyntex.TourismApp.Services.RegistrationRequestService;
import com.cyntex.TourismApp.Util.JSONHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping(value="/api")
public class BackEndRestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @Autowired
    private FoodRequestHandler foodRequestHandler;

    @Autowired
    private RatingProfileRequestHandler ratingProfileRequestHandler;

    @Autowired
    private TestRequestHandler testRequestHandler;
    
    @Autowired
    private DiscoverTouristFriendService discoverTouristFriendService;
    
    @Autowired
    private CreateChatGroupService createChatGroupService;
    
    @Autowired
    private AddtouristFriendService addtouristFriendService;
    
    @Autowired
    private DiscoverTouristAttractionService discoverTouristAttractionService;
    
    @RequestMapping(value="/serviceCheck",method= RequestMethod.GET)
    public String serviceCheck() throws Exception{
    	return JSONHandler.parseToJSON("Service is ok");
    }


    @CrossOrigin()
    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String requestData(@RequestBody String data) throws Exception {
        RegistrationRequestBean scoreBoardRequest = JSONHandler.parseFromJSON(data, RegistrationRequestBean.class);
        BaseResponse response = registrationRequestService.requestRegistration(scoreBoardRequest);
        return JSONHandler.parseToJSON(response);
    }

    @CrossOrigin()
    @RequestMapping(value="/shops/list",method= RequestMethod.POST)
    public String requestFoodShopData(@RequestBody String data) throws Exception {
        ShopDetailsRequestBean shopDetailsRequestBean = JSONHandler.parseFromJSON(data, ShopDetailsRequestBean.class);
        BaseResponse response = foodRequestHandler.handle(shopDetailsRequestBean);
        return JSONHandler.parseToJSON(response);
    }

    @CrossOrigin()
    @RequestMapping(value="/user/rating_profile",method= RequestMethod.POST)
    public String requestUserRatingProfile(@RequestBody String data) throws Exception {
        RatingsProfileRequestBean shopDetailsRequestBean = JSONHandler.parseFromJSON(data, RatingsProfileRequestBean.class);
        BaseResponse response = ratingProfileRequestHandler.handle(shopDetailsRequestBean);
        return JSONHandler.parseToJSON(response);
    }

    @CrossOrigin()
    @RequestMapping(value="/test/save_text",method= RequestMethod.POST)
    public String saveTextRequest(@RequestBody String data) throws Exception {
        TestBean testBean = JSONHandler.parseFromJSON(data, TestBean.class);
        testRequestHandler.handle(testBean);
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @RequestMapping(value="/auth/user",method= RequestMethod.GET)
    public String version(){
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @RequestMapping(value="/options",method= RequestMethod.OPTIONS)
    public String options(){
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value="/auth/admin",method= RequestMethod.GET)
    public String versionAdmin(){
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value="/updateData",method= RequestMethod.POST)
    public String updateData(@RequestBody String data) throws Exception {
//        ScoreUpdateRequestBean scoreUpdateRequest = JSONHandler.parseFromJSON(data,ScoreUpdateRequestBean.class);
//        BaseResponse response = new BaseResponse();
        return "NOT IMPL";
    }
    @CrossOrigin()
    @RequestMapping(value="/discoverTouristFriends", method= RequestMethod.POST)
    public String discoverTouristFriend(@RequestBody String data)throws Exception{
    	//there should be a bean
    	DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean = JSONHandler.parseFromJSON(data, DiscoverTouristFriendRequestBean.class);
    	BaseResponse response = discoverTouristFriendService.discoverTouristFriend(discoverTouristFriendRequestBean);
        return JSONHandler.parseToJSON(response);
    	
    }
    
    
    @CrossOrigin()
    @RequestMapping(value="/createChatGroup" , method = RequestMethod.POST)
    public String createChatGroup(@RequestBody String data)throws Exception{
    	CreateChatGroupRequestBean createChatGroupRequestBean= JSONHandler.parseFromJSON(data, CreateChatGroupRequestBean.class);
    	BaseResponse response= createChatGroupService.createChatGroup(createChatGroupRequestBean);
    	return JSONHandler.parseToJSON(response);
    	
    	
    }
    
    @CrossOrigin()
    @RequestMapping(value="/addTouristFriend", method= RequestMethod.POST)
    public String AddTouristFriend(@RequestBody String data)throws Exception{
    	AddFriendRequestBean addFriendRequestBean = JSONHandler.parseFromJSON(data, AddFriendRequestBean.class);
    	BaseResponse response = addtouristFriendService.addTouristFriend(addFriendRequestBean);
    	return JSONHandler.parseToJSON(response);
    	
    	
    }
    
    @CrossOrigin()
    @RequestMapping(value="/discoverTouristAttraction")
    public String discoverTouristAttraction(@RequestBody String data) throws Exception{
    	DiscoverTouristAttractionRequestBean discoverTouristFriendRequestBean= JSONHandler.parseFromJSON(data, DiscoverTouristAttractionRequestBean.class);
    	BaseResponse response =discoverTouristAttractionService.discoverTouristAttraction(discoverTouristFriendRequestBean);
    	return JSONHandler.parseToJSON(response);
    }




}
