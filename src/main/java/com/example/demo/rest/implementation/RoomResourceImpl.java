package com.example.demo.rest.implementation;

import com.example.demo.entity.Room;
import com.example.demo.entity.Users;
import com.example.demo.rest.RoomResource;
import com.example.demo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Room")
@RequiredArgsConstructor
public class RoomResourceImpl implements RoomResource {
    private final RoomService roomService;
    @Override
    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }
    @Override
    @PutMapping("{room_id}")
    public Room updateRoom(@PathVariable Long room_id, @RequestBody Room room){
        return roomService.updateRoom(room ,room_id);
    }
}
