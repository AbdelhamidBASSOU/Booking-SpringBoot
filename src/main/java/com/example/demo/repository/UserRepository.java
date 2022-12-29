package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Override
    Optional<Users> findById(Long aLong);

    Users findByEmail(String Email);

    Users findByUsername(String username);
    Users findByUsernameAndRole(String username , Role role);
}
