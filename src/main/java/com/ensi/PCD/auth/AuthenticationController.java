package com.ensi.PCD.auth;

import com.ensi.PCD.model.Vendeur;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@CrossOrigin(origins = "*")
@EnableWebMvc
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/registerVend")
  public ResponseEntity<AuthenticationResponse> registerVendeur(
          @RequestBody RegisterVendeurRequest requestVendeur
  ) {
    return ResponseEntity.ok(service.registerVendeur(requestVendeur));
  }

  @PostMapping("/authenticateVend")
  public ResponseEntity<AuthenticationResponse> authenticateVendeur(
          @RequestBody AuthenticationRequest requestVendeur
  ) {
    return ResponseEntity.ok(service.authenticateVendeur(requestVendeur));
  }



}
