package com.Rating.Service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rating.Service.Entity.Rating;
import com.Rating.Service.Repository.RatingRepository;
import com.Rating.Service.Services.RatingService;
@Service
public class RatingServiveImpl implements RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		String rendom=UUID.randomUUID().toString();
		rating.setRatingId(rendom);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRating() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String UserId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(UserId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
