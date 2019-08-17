package com.cyntex.TourismApp.Logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRequestBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendResponseBean;
import com.cyntex.TourismApp.Beans.RatingProfileFetchQueryBasedOnCategoryBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.RatingsProfileRequestBean;
import com.cyntex.TourismApp.Beans.RatingsProfileResponseBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Beans.UserRating;
import com.cyntex.TourismApp.Persistance.UserProfileDAO;
import com.cyntex.TourismApp.Persistance.UserRatingsProfileDAO;
import com.cyntex.TourismApp.Util.UserRatingCalculator;

@Component
public class DiscoverTouristFriendRequestHandler {

	@Autowired
	private UserRatingCalculator userRatingCalculator;

	@Autowired
	private UserRatingsProfileDAO userRatingsProfileDAO;

	@Autowired
	private UserProfileDAO userProfileDAO;

	public BaseResponse handle(
		DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean) {
		
        DiscoverTouristFriendResponseBean responseBean= new DiscoverTouristFriendResponseBean();
        
		RatingsProfileResponseBean ProfileResponseBean = new RatingsProfileResponseBean();
		
		List<UserRating> requestedUserRatingList = new ArrayList<UserRating>();
		
		List<RegistrationRequestBean> touristFriendProfileList = new ArrayList<RegistrationRequestBean>();
		String requesterUsername=discoverTouristFriendRequestBean.getUsername();
		// System.out.println("category1 ");
		try {
			// List<RatingsProfileQueryResponseBean> queryResponse =
			// userRatingsProfileDAO.getUserRatingsProfile(ratingsProfileRequestBean.getUsername());
			// responseBean=userRatingcalcalculator.RatingProfileResponse(queryResponse);

			List<RatingsProfileQueryResponseBean> queryResponse = userRatingsProfileDAO
					.getUserRatingsProfile(requesterUsername);

			requestedUserRatingList = userRatingCalculator
					.RatingProfileResponse(queryResponse).getUserRatings();
			System.out.println("userRatingList "
					+ requestedUserRatingList.size());
			ProfileResponseBean = userRatingCalculator
					.RatingProfileResponse(queryResponse);
			ArrayList<String> counterBucket = new ArrayList<String>();
			for (UserRating userRating : requestedUserRatingList) {
				System.out.println("category " + userRating.getCategory());
				System.out.println("username "
						+ discoverTouristFriendRequestBean.getUsername());
				List<DiscoverTouristFriendQueryResponseBean> discoverTouristFriendQuaryResponseBeanList = userRatingsProfileDAO.getAverageRating(userRating.getCategory(),requesterUsername);
              
				for (DiscoverTouristFriendQueryResponseBean discoverTouristFriendQueryResponseBean : discoverTouristFriendQuaryResponseBeanList) {
					double averageRating = discoverTouristFriendQueryResponseBean.getAverageRating();
					String usernameOfQuaryResponseBean=discoverTouristFriendQueryResponseBean.getUsername();
					System.out.println("averageRating " + averageRating);
					if ((!counterBucket.contains(usernameOfQuaryResponseBean))&& averageRating >= userRating.getRating() - 1
							&& averageRating <= userRating.getRating() + 1) {
						counterBucket.add(usernameOfQuaryResponseBean);
						touristFriendProfileList.add(userProfileDAO
										.getUserRatingsProfile(usernameOfQuaryResponseBean));
						if (touristFriendProfileList.size() >= 10) {
							break;
						}
					}

				}

			}
			// responseBean=userRatingCalculator.RatingProfileResponse(queryResponse);
			 responseBean.setStatus("SUCCESS");
		} catch (Exception e) {
		    responseBean.setStatus("FAIL : "+e.getMessage());
			//System.out.println(e);
		}
		responseBean.setRegistrationRequestBean(touristFriendProfileList);
		return responseBean;

		// List<UserRatings> requestedUserRatings =
		// userRatingCalculator.handle(ratingsProfileRequestBean)

	}

}
