package com.cyntex.TourismApp.Beans;

import java.util.List;

public class RatingsProfileResponseBean extends BaseResponse{
    private List<UserRating> userRatings;

    public List<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<UserRating> userRatings) {
        this.userRatings = userRatings;
    }
}
