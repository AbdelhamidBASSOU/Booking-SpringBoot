package com.example.demo.entity.rest;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Room;
import com.example.demo.entity.Users;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Reservation")
@RequiredArgsConstructor
public class ReservationResource {

    private final ReservationService reservationService;
    private final RoomRepository roomRepository;
    @PostMapping("/add")
   // @PostAuthorize("hasAnyAuthority('Admin','Manager','Client')")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @PutMapping("{reservation_id}")
    @PostAuthorize("hasAnyAuthority('Admin','Manager','Client')")
    public Reservation updateReservation(@PathVariable Long reservation_id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation ,reservation_id);
    }

    @DeleteMapping("/delete/{id}")
    @PostAuthorize("hasAnyAuthority('Admin','Manager','Client')")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    @PostAuthorize("hasAnyAuthority('Admin','Manager','Client')")
    public Reservation getOne(@PathVariable("id") Long id) {
        return reservationService.getOne(id);
    }

    @GetMapping("/")
    public List<Reservation> findAll(){
        return reservationService.getAll();

    }
    @PostMapping("/reservations")
    public ResponseEntity getAllByUserId(@RequestBody Users user){
        try {
            List<Reservation> reservationResponse = reservationService.getReservationByUserId(user);
            System.out.println(reservationResponse);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservationResponse);
        }catch (IllegalStateException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @GetMapping("/checkAvailability")
    public boolean checkAvailability(@RequestParam Long roomId,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        Room room = roomRepository.findById(roomId).orElse(null);
        return reservationService.isRoomAvailable(room, startDate, endDate);
    }


}
