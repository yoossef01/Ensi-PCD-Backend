package com.ensi.PCD.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/*
@CrossOrigin(origins = "*")
@EnableWebMvc
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class authVendeurController {
    private final AuthVendeurService service;

    @PostMapping("/register/ven")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterVendeurRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate/ven")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}     */