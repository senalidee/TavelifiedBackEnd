package com.cyntex.TourismApp.Logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRatingDetailQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendRequestBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristFriendUserProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.RatingProfileFetchQueryBasedOnCategoryBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.RatingsProfileRequestBean;
import com.cyntex.TourismApp.Beans.RatingsProfileResponseBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Beans.UserRating;
import com.cyntex.TourismApp.Persistance.FriendListDAO;
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
	
	@Autowired
	private FriendListDAO friendListDAO;

	public BaseResponse handle(
		DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean) {
		
        DiscoverTouristFriendResponseBean responseBean= new DiscoverTouristFriendResponseBean();
        
		RatingsProfileResponseBean ProfileResponseBean = new RatingsProfileResponseBean();
		
		List<UserRating> requestedUserRatingList = new ArrayList<UserRating>();
		
		List<DiscoverTouristFriendUserProfileQueryResponseBean> touristFriendProfileList = new ArrayList<DiscoverTouristFriendUserProfileQueryResponseBean>();
		String requesterUsername=discoverTouristFriendRequestBean.getUsername();

		try {
	

			List<RatingsProfileQueryResponseBean> queryResponse = userRatingsProfileDAO
					.getUserRatingsProfile(requesterUsername);

			requestedUserRatingList = userRatingCalculator
					.RatingProfileResponse(queryResponse).getUserRatings();
//			System.out.println("userRatingList "
//					+ requestedUserRatingList.size());
			ProfileResponseBean = userRatingCalculator
					.RatingProfileResponse(queryResponse);
			ArrayList<String> counterBucket = new ArrayList<String>();
			for (UserRating userRating : requestedUserRatingList) {

				List<DiscoverTouristFriendRatingDetailQueryResponseBean> discoverTouristFriendQuaryResponseBeanList = userRatingsProfileDAO.getAverageRating(userRating.getCategory(),requesterUsername);
              
				for (DiscoverTouristFriendRatingDetailQueryResponseBean discoverTouristFriendRatingDetailQueryResponseBean : discoverTouristFriendQuaryResponseBeanList) {
					double averageRating = discoverTouristFriendRatingDetailQueryResponseBean.getAverageRating();
					String usernameOfQuaryResponseBean=discoverTouristFriendRatingDetailQueryResponseBean.getUsername();
	//				System.out.println("averageRating " + averageRating);
					boolean isRecordAlreadyExists=friendListDAO.isRecordAlreadyExists(requesterUsername, usernameOfQuaryResponseBean);
					if ( !isRecordAlreadyExists &&(!counterBucket.contains(usernameOfQuaryResponseBean))&& averageRating >= userRating.getRating() - 1
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
			
			 responseBean.setStatus("SUCCESS");
		} catch (Exception e) {
		    responseBean.setStatus("FAIL : "+e.getMessage());
			
		}
		responseBean.setUserProfiles(touristFriendProfileList);
		return responseBean;

	
	}

}
