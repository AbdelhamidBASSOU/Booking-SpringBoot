package com.example.demo.service;

import com.example.demo.entity.Room;

public interface RoomService {
    Room addRoom(Room room);


    Room updateRoom(Room room, Long id);
}
