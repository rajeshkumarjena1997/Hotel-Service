package com.User.Service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.User.Service.Entitys.Hotel;
import com.User.Service.Entitys.Rating;
import com.User.Service.Entitys.User;
import com.User.Service.Exceptions.ResourceNotFoundException;

import com.User.Service.ExternalServices.HotelServices;
import com.User.Service.Repositories.UserRepositories;
import com.User.Service.Services.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserRepositories userRepositories;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelServices hotelServices;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub

		String rendomId = UUID.randomUUID().toString();
		user.setUserId(rendomId);
		return userRepositories.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepositories.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepositories.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Given Id Not in Serner : " + userId));
		// http://192.168.17.65:8557/rating/users/f409c644-4790-4e78-8b3a-5ea72d69d203
		Rating[] ratingofUser = restTemplate.getForObject("http://RATING-SERVICE/rating/users/" + user.getUserId(),
				Rating[].class);
		logger.info("{}", ratingofUser);

		List<Rating> ratings = Arrays.stream(ratingofUser).toList();

		List<Rating> rstingList = ratings.stream().map(rating -> {
			// http://192.168.17.65:8556/hotels/76c378e2-6fef-4ea6-9f45-c9dc4c7d4a6a
			// ResponseEntity<Hotel> forEntity =
			// restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" +
			// rating.getHotelId(), Hotel.class);

			Hotel hotel = hotelServices.getHotel(rating.getHotelId());
			// logger.info("response status code :{} ", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRating(rstingList);
		return user;
	}

}
