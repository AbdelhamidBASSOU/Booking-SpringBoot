package com.example.demo.rest.implementation;

import com.example.demo.entity.Users;
import com.example.demo.rest.UserResource;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResourceImpl implements UserResource {

    private final UserService userService;
    @Override
    @PostMapping("/add")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }
    @Override
    @PutMapping("{user_id}")
    public Users updateUser(@PathVariable Long user_id, @RequestBody Users user){
        return userService.updateUser(user_id,user);
    }
}
