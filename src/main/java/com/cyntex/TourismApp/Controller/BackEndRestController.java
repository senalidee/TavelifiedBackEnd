package com.cyntex.TourismApp.Controller;


import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.LoginRequestBean;
import com.cyntex.TourismApp.Beans.RatingsProfileRequestBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Logic.FoodRequestHandler;
import com.cyntex.TourismApp.Logic.RatingProfileRequestHandler;
import com.cyntex.TourismApp.Logic.TestRequestHandler;
import com.cyntex.TourismApp.Services.AuthService;
import com.cyntex.TourismApp.Util.FSManager;
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
    private AuthService authService;

    @Autowired
    private FoodRequestHandler foodRequestHandler;

    @Autowired
    private RatingProfileRequestHandler ratingProfileRequestHandler;

    @Autowired
    private TestRequestHandler testRequestHandler;


    @CrossOrigin()
    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String registerUser(@RequestBody String data) throws Exception {
        try {
            RegistrationRequestBean registrationRequestBean = JSONHandler.parseFromJSON(data, RegistrationRequestBean.class);
            BaseResponse response = authService.requestRegistration(registrationRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody String data) throws Exception {
        try {
            LoginRequestBean loginRequestBean = JSONHandler.parseFromJSON(data, LoginRequestBean.class);
            BaseResponse response = authService.loginUser(loginRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public byte[] getImage(@RequestParam("id") String imageID) throws Exception {
        try {
            return FSManager.retrieveImage(imageID);
        } catch (Exception e) {
            return null;
        }
    }

//    @CrossOrigin()
//    @RequestMapping(value="/shops/list",method= RequestMethod.POST)
//    public String requestFoodShopData(@RequestBody String data) throws Exception {
//        ShopDetailsRequestBean shopDetailsRequestBean = JSONHandler.parseFromJSON(data, ShopDetailsRequestBean.class);
//        BaseResponse response = foodRequestHandler.handle(shopDetailsRequestBean);
//        return JSONHandler.parseToJSON(response);
//    }

    @CrossOrigin()
    @RequestMapping(value="/user/rating_profile",method= RequestMethod.POST)
    public String requestUserRatingProfile(@RequestBody String data) throws Exception {
        RatingsProfileRequestBean shopDetailsRequestBean = JSONHandler.parseFromJSON(data, RatingsProfileRequestBean.class);
        BaseResponse response = ratingProfileRequestHandler.handle(shopDetailsRequestBean);
        return JSONHandler.parseToJSON(response);
    }

//    @CrossOrigin()
//    @RequestMapping(value="/test/save_text",method= RequestMethod.POST)
//    public String saveTextRequest(@RequestBody String data) throws Exception {
//        TestBean testBean = JSONHandler.parseFromJSON(data, TestBean.class);
//        testRequestHandler.handle(testBean);
//        return "{SUCCESS}";
//    }

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
        return "NOT IMPL";
    }




}
