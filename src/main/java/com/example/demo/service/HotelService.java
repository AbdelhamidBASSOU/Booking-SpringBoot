package com.example.demo.service;

import com.example.demo.entity.Hotel;

import java.util.List;

public interface HotelService {
    void deleteById(Long id);

    Hotel getOne(Long aLong);

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel, Long id);

    List<Hotel> getAll();
}
