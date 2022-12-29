package com.example.demo.service.implementation;

import com.example.demo.entity.*;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.Collections;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final   UserRepository userRepository;
    private final  RoleRepository roleRepository;

    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;
    @Override
    public Optional<Users> getOnById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users addUser(Users user) {

        return userRepository.save(user);
    }
    @Override
    public Users updateUser(Long id, Users user) {
        Users userWithId= userRepository.findById(id).orElse(null);
        if(userWithId != null ){
            userWithId.setFirstName(user.getFirstName());
            userWithId.setLastName(user.getLastName());
            userWithId.setUsername(user.getUsername());
            userWithId.setEmail(user.getEmail());
            userWithId.setPassword(user.getPassword());
            userWithId.setReference(user.getReference());
            userWithId.setRole(user.getRole());

            return userWithId;
        }else{
            throw new IllegalStateException("room cannot be found");
        }
    }


    @Override
    public Users findByEmail(String email){
        Users users = userRepository.findByEmail(email);

        return users;
    }

    @Override
    public List <Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Users user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRole().add(role);
    }
    @Override
    public void banUser(String username){
        Users user=userRepository.findByUsername(username);
        user.setBanned(true);
    }
    @Override
    public void approveHotel(Long id){
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        hotel.setApproved(true);
    }

    @Override
    public void acceptReservation(Long id){
        Reservation res = reservationRepository.findById(id).orElse(null);
        res.setStatus(Status.accepted);
    }
}
