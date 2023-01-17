package com.example.demo.service.implementation;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Room;
import com.example.demo.entity.Status;
import com.example.demo.entity.Users;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    private final UserService userService;


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
        Room room1 =roomRepository.findById(reservation.getRoom().getId()).orElse(null);

     boolean  available =  isRoomAvailable(room1,reservation.getStartDate(),reservation.getEndDate());
     double price = resPrice(room1,reservation.getStartDate(),reservation.getEndDate());

   if(available){
         reservation.setRoom(room1);
         reservation.setTotalPrice(price);
         reservation.setStatus(Status.inProgress);
         return reservationRepository.save(reservation);
     }else{
         throw new IllegalStateException("reservation cannot be passed cuz the room is not available");}
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long id) {
        Reservation reservationWithId=reservationRepository.findById(id).orElse(null);
   if(reservationWithId != null){
       reservationWithId.setTotalPrice(reservation.getTotalPrice());
       reservationWithId.setStartDate(reservation.getStartDate());
       reservationWithId.setEndDate(reservation.getEndDate());
       reservationWithId.setClient(reservation.getClient());
       reservationWithId.setRoom(reservation.getRoom());
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

    @Override
    public void acceptReservation(Long id){
        Reservation res = reservationRepository.findById(id).orElse(null);
        res.setStatus(Status.accepted);
    }
    @Override
    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        List<Reservation> reservations = room.getListReservation();
        for (Reservation reservation : reservations) {
            if (reservation.getStartDate().isBefore(endDate) && reservation.getEndDate().isAfter(startDate)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public double resPrice(Room room, LocalDate startDate, LocalDate endDate){
        long numberOfNights = ChronoUnit.DAYS.between(startDate, endDate);
        double price=room.getPrice();
        return numberOfNights * price;
    }
    @Override
    public List<Reservation> getReservationByUserId(Users users) {
        System.out.println(this.reservationRepository.findByClient(users));
        return reservationRepository.findByClient(users);
    }
}
