package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Override
    void deleteById(Long id);

    List<Reservation> findByClient(Users user);
}
