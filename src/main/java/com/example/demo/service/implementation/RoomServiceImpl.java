package com.example.demo.service.implementation;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
private final RoomRepository roomRepository;
    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room, Long id) {
          Room roomWithId= roomRepository.findById(room.getId()).orElse(null);
         if(id != null){
          roomWithId.setCapacity(room.getCapacity());
          roomWithId.setRoomNumber(room.getRoomNumber());
          roomWithId.setType(room.getType());
          roomWithId.setPrice(room.getPrice());
          roomWithId.setReservation(room.getReservation());
          roomWithId.setHotel(room.getHotel());

          return roomWithId;
         }else{
             throw new IllegalStateException("room cannot be find");
         }

    }



}
