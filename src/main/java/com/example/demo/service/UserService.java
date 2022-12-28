package com.example.demo.service;

import com.example.demo.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {


    Optional<Users> getOnById(Long id);
    Users addUser(Users user);
    Users updateUser(Long id, Users user);
    Users getUser(String username);

    List<Users> getUsers();

    UserDetails findByEmail(String email);
}
