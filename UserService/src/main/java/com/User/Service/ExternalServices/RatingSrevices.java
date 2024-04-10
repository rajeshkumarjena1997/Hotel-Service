package com.User.Service.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.User.Service.Entitys.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingSrevices {
//get

	// post
	@PostMapping("/ratings")
	public Rating createRating(Rating values);

	/// put
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

	@DeleteMapping("/ratings/{ratingId}")
	public void deletRating(@PathVariable("ratingId") String ratingId);
}
