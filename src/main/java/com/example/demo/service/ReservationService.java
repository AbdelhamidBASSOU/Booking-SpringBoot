package com.example.demo.service;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void deleteById(Long id);
    Reservation getOne(Long aLong);

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation, Long id);

    List<Reservation> getAll();

    void acceptReservation(Long id);

    boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate);

    double resPrice(Room room, LocalDate startDate, LocalDate endDate);
}
