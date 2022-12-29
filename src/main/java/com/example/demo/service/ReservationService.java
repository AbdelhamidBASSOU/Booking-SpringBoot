package com.example.demo.service;

import com.example.demo.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void deleteById(Long id);
    Reservation getOne(Long aLong);

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation, Long id);

    List<Reservation> getAll();
}
