package com.cyntex.TourismApp.Controller;


import com.cyntex.TourismApp.Beans.RatingsProfileRequestBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Beans.ShopDetailsRequestBean;
import com.cyntex.TourismApp.Logic.FoodRequestHandler;
import com.cyntex.TourismApp.Logic.RatingProfileRequestHandler;
import com.cyntex.TourismApp.Services.RegistrationRequestService;
import com.cyntex.TourismApp.Util.JSONHandler;
import com.cyntex.TourismApp.Beans.BaseResponse;
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




}
