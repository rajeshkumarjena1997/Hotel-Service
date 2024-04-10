package com.Rating.Service.Services;

import java.util.List;

import com.Rating.Service.Entity.Rating;

public interface RatingService {
	Rating create(Rating rating);

	List<Rating> getRating();

	List<Rating> getRatingByUserId( String UserId);
	
	List<Rating> getRatingByHotelId(String hotelId);
}
