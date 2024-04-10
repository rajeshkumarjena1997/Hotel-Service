package com.Hotel.Service.Services;

import java.util.List;

import com.Hotel.Service.Entitrs.Hotel;

public interface HotelService {
	Hotel create(Hotel hotel);

	List<Hotel> getAll();

	Hotel get(String id);
}
