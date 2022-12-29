package com.example.demo.rest;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Reservation")
@RequiredArgsConstructor
public class ReservationResource {

    private final ReservationService reservationService;
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @PutMapping("{reservation_id}")
    public Reservation updateReservation(@PathVariable Long reservation_id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation ,reservation_id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public Reservation getOne(@PathVariable("id") Long id) {
        return reservationService.getOne(id);
    }

    @GetMapping("/")
    public List<Reservation> findAll(){
        return reservationService.getAll();
    }


}
