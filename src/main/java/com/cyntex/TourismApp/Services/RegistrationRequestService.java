package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Logic.RegistrationRequestHandler;
import com.cyntex.TourismApp.Beans.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestService {

    @Autowired
    private RegistrationRequestHandler registrationRequestHandler;

    public BaseResponse requestRegistration(RegistrationRequestBean requestBean){
        return registrationRequestHandler.handle(requestBean);
    }
}
