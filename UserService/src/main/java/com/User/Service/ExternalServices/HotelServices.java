package com.User.Service.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.User.Service.Entitys.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {
	@GetMapping("/hotels/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
///hotels/{hotelId}