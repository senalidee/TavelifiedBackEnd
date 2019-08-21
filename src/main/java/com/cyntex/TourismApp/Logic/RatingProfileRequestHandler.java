package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.UserRatingsProfileDAO;
import com.cyntex.TourismApp.Util.UserRatingCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RatingProfileRequestHandler {

    @Autowired
    private UserRatingsProfileDAO userRatingsProfileDAO;
    
    @Autowired
    private UserRatingCalculator userRatingcalcalculator;

    public BaseResponse handle(RatingsProfileRequestBean ratingsProfileRequestBean) {
        RatingsProfileResponseBean responseBean = new RatingsProfileResponseBean();
        try {
            List<RatingsProfileQueryResponseBean> queryResponse =
                    userRatingsProfileDAO.getUserRatingsProfile(ratingsProfileRequestBean.getUsername());
            responseBean=userRatingcalcalculator.RatingProfileResponse(queryResponse);
            responseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }
}
