package com.example.demo.entity.rest;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel")
public class HotelResource {
    private final HotelService hotelService;
    @PostMapping("/add")
    @PostAuthorize("hasAnyAuthority('Manager','Admin')")

    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("{hotelId}")
    @PostAuthorize("hasAnyAuthority('Manager','Admin')")

    public Hotel updateHotel(@PathVariable Long hotelId, @RequestBody Hotel hotel){
        return hotelService.updateHotel(hotel ,hotelId);
    }

    @DeleteMapping("/delete/{id}")
    @PostAuthorize("hasAnyAuthority('Manager','Admin')")

    public void deleteById(@PathVariable Long id) {
        hotelService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    //@PostAuthorize("hasAnyAuthority('Manager','Admin','Client')")

    public Hotel getOne(@PathVariable("id") Long id) {
        return hotelService.getOne(id);
    }

    @GetMapping("/")
   // @PostAuthorize("hasAnyAuthority('Manager','Admin','Client')")

    public List<Hotel> findAll(){
        return hotelService.getAll();
    }

}
