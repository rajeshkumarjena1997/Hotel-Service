package com.Rating.Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rating.Service.Entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
 //custom find of method
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
