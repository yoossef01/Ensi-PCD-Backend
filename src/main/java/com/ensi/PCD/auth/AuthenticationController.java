package com.ensi.PCD.auth;

import com.ensi.PCD.model.Vendeur;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
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
  @GetMapping("/vendeur/{id}")
  public ResponseEntity<Vendeur> getVendeurById(@PathVariable("id") Integer id) {
    var vendeur = service.getVendeurById(id);
    if (vendeur == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(vendeur);
  }
  @GetMapping("/vendeur/email/{email}")
  public ResponseEntity<Vendeur> getVendeurByEmail(@PathVariable("email") String email) {
    var vendeur = service.getVendeurByEmail(email);
    if (vendeur == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(vendeur);
  }
  @PutMapping("/update")
  public void updateVendeur(@RequestBody Vendeur v){
    this.service.SaveVendeur( v );
  }

}
