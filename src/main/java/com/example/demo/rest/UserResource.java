package com.example.demo.rest;

import com.example.demo.entity.Users;
import org.springframework.web.bind.annotation.*;

@RestController
public interface UserResource {
    @PostMapping("/add")
    Users addUser(@RequestBody Users user);

    @PutMapping("{user_id}")
    Users updateUser(@PathVariable Long user_id, @RequestBody Users user);
}
