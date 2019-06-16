package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Persistance.RegistrationDAO;
import com.cyntex.TourismApp.Beans.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestHandler {

    @Autowired
    private RegistrationDAO registrationDAO;

    public BaseResponse handle(RegistrationRequestBean requestBean){
        BaseResponse response = new BaseResponse();
        try{
            registrationDAO.addNewRecord(
                    requestBean.getFbId(),
                    requestBean.getFirstName(),
                    requestBean.getLastName(),
                    requestBean.getGender(),
                    requestBean.getCountry(),
                    "",
                    requestBean.getEmail(),
                    requestBean.getBirthday(),
                    requestBean.getFbId(),
                    requestBean.getPicture(),
                    requestBean.getFbToken().toString(),
                    requestBean.getPassword());
            response.setStatus("SUCCESS");
        }catch (Exception e) {
            response.setStatus("FAILED: Cannot register this user");
        }
        return response;
    }
}
