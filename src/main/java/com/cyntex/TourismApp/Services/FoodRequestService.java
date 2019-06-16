package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.ShopDetailsRequestBean;
import com.cyntex.TourismApp.Logic.FoodRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodRequestService {

    @Autowired
    private FoodRequestHandler foodRequestHandler;

    public BaseResponse requestFoodShopList(ShopDetailsRequestBean requestBean){
        return foodRequestHandler.handle(requestBean);
    }
}