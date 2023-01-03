package com.example.demo.rest;

import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Room")
@RequiredArgsConstructor
public class RoomResource {
    private final RoomService roomService;

    @PostMapping("/add")
    @PostAuthorize("hasAnyAuthority('Manager','Admin')")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @PutMapping("{room_id}")
    @PostAuthorize("hasAnyAuthority('Admin','Manager')")
    public Room updateRoom(@PathVariable Long room_id, @RequestBody Room room){
        return roomService.updateRoom(room ,room_id);
    }

    @GetMapping("/")
    @PostAuthorize("hasAnyAuthority('Admin','Manager','Client')")
    public List<Room> findAll(){
        return roomService.findAll();
    }
}
