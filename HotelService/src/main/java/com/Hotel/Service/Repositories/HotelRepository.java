package com.Hotel.Service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hotel.Service.Entitrs.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
