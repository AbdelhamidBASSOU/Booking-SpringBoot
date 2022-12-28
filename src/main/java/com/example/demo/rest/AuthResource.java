package com.example.demo.rest;

import com.example.demo.service.dto.AuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthResource {
    @PostMapping("/authenticate")
    ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request);
}
