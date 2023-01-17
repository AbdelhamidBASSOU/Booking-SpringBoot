package com.example.demo.security;

import com.example.demo.entity.Users;
import com.example.demo.security.model.myUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(r ->{
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        });
        return new myUser(user.getUsername(),user.getPassword(),authorities, user.getId(),user.isBanned(),user.getFirstName()+' '+user.getLastName());
    }
}
