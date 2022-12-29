package com.example.demo.service;

import com.example.demo.entity.Room;

import java.util.List;

public interface RoomService {
    Room addRoom(Room room);


    Room updateRoom(Room room, Long id);

    List<Room> findAll();


}
