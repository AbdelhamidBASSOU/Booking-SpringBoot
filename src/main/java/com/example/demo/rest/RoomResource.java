package com.example.demo.rest;

import com.example.demo.entity.Room;
import com.example.demo.entity.Users;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RoomResource {
    @PostMapping("/add")
    Room addRoom(@RequestBody Room room);

    @PutMapping("{room_id}")
    Room updateRoom(@PathVariable Long room_id, @RequestBody Room room);
}
