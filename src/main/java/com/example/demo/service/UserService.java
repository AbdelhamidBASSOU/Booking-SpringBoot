package com.example.demo.service;

import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {


    Optional<Users> getOnById(Long id);
    Users addUser(Users user);
    Users updateUser(Long id, Users user);

    Users findByEmail(String email);

    List<Users> getAll();

    void addRoleToUser(String username, String roleName);

    void banUser(String username);

    void approveHotel(Long id);

    void acceptReservation(Long id);
}
