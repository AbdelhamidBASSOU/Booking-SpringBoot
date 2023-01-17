package com.example.demo.service.implementation;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Users;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    @Override
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }
    @Override
    public Hotel getOne(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
         hotel.setApproved(false);
        return hotelRepository.save(hotel);

    }

    @Override
    public Hotel updateHotel(Hotel hotel, Long id){
            Hotel hotelWithId=hotelRepository.findById(id).orElse(null);
           Users manager= hotelWithId.getManager();
            if(hotelWithId != null){
            hotelWithId.setName(hotel.getName());
            hotelWithId.setCity(hotel.getCity());
            hotelWithId.setAddress(hotel.getAddress());
            hotelWithId.setRoomList(hotel.getRoomList());
            hotelWithId.setManager(hotel.getManager());
                return hotelRepository.save(hotelWithId) ;
            }else{
                throw new IllegalStateException("Hotel cannot be found !");
            }
    }

    @Override
    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }
    @Override
    public Hotel approveHotel(Long id ){
        Hotel hotelWithId = hotelRepository.findById(id).orElse(null);
        hotelWithId.setApproved(true);
        return hotelRepository.save(hotelWithId);

    }

}
