package com.Hotel.Service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.Service.Entitrs.Hotel;
import com.Hotel.Service.Exception.ResourceNotFoundException;
import com.Hotel.Service.Repositories.HotelRepository;
import com.Hotel.Service.Services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel id is not gound"));
	}

}
