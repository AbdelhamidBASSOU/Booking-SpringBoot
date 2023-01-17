package com.example.demo.entity.rest;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping("/add")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    @PutMapping("{user_id}")
    @PostAuthorize("hasAnyAuthority('Admin')")
    public Users updateUser(@PathVariable Long user_id, @RequestBody Users user){
        return userService.updateUser(user_id,user);
    }
    @GetMapping("/")
    @PostAuthorize("hasAnyAuthority('Admin')")
    public List<Users> getUsers(){
        return userService.getAll();
    }


}
