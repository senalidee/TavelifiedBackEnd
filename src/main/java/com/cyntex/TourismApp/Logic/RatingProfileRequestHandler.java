package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.UserRatingsProfileDAO;
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

    public BaseResponse handle(RatingsProfileRequestBean ratingsProfileRequestBean) {
        RatingsProfileResponseBean responseBean = new RatingsProfileResponseBean();
        try {
            List<RatingsProfileQueryResponseBean> queryResponse =
                    userRatingsProfileDAO.getUserRatingsProfile(ratingsProfileRequestBean.getUsername());
            Map<String, List<Integer>> userRatingsTotals = new HashMap<>();
            for (RatingsProfileQueryResponseBean queryResponseBean : queryResponse) {
                List<Integer> ratingValue = userRatingsTotals.get(queryResponseBean.getCategory());
                if (ratingValue == null) {
                    ratingValue = new ArrayList<>();
                    ratingValue.add(queryResponseBean.getRating());
                    userRatingsTotals.put(queryResponseBean.getCategory(), ratingValue);
                } else {
                    ratingValue.add(queryResponseBean.getRating());
                }
            }
            responseBean.setUserRatings(new ArrayList<>());
            for (String category : userRatingsTotals.keySet()) {
                int totalRating = userRatingsTotals.get(category)
                                                   .stream()
                                                   .mapToInt(x -> x).sum();
                double averageRating =
                        Math.round((((double) totalRating / userRatingsTotals.get(category).size())) * 100.0) / 100.0;
                responseBean.getUserRatings().add(new UserRating(category, averageRating));
            }
            responseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }
}
