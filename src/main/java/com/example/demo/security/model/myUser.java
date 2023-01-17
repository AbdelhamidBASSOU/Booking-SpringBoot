package com.example.demo.security.model;

import com.example.demo.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class myUser extends User {
    private final Long id;
    private final boolean is_active;
    private final String name;

    public myUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, boolean is_active, String name) {
        super(username, password, authorities);
        this.id = id;
        this.is_active = is_active;
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public String getName() {
        return name;
    }
}
