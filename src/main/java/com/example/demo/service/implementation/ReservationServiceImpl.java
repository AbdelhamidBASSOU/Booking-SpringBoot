package com.example.demo.service.implementation;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;


    @Override
    public void deleteById(Long id) {
         reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getOne(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        reservation.setStatus(Status.inProgress);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long id) {
        Reservation reservationWithId=reservationRepository.findById(id).orElse(null);
   if(reservationWithId != null){
       reservationWithId.setTotalPrice(reservation.getTotalPrice());
       reservationWithId.setStartDate(reservation.getStartDate());
       reservationWithId.setEndDate(reservation.getEndDate());
       reservationWithId.setClient(reservation.getClient());
       reservationWithId.setRoomList(reservation.getRoomList());
       reservationWithId.setStatus(reservation.getStatus());
       return reservationWithId;
   }else{
       throw new IllegalStateException("reservation cannot be found");
   }

    }
    @Override
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }
}
