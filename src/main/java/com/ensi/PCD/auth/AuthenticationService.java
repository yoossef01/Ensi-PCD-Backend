package com.ensi.PCD.auth;

import com.ensi.PCD.Dao.VendeurRepository;
import com.ensi.PCD.config.JwtService;
import com.ensi.PCD.model.Role;
import com.ensi.PCD.Dao.UserRepository;
import com.ensi.PCD.model.RoleVendeur;
import com.ensi.PCD.model.Vendeur;
import com.ensi.PCD.token.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final VendeurRepository vendeurRepository;
  private final TokenVendeurRepository tokenVendeurRepository;
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = com.ensi.PCD.model.Client.builder()
        .nom(request.getNom())
        .prenom(request.getPrenom()).adresse(request.getAdresse()).tel(request.getTel())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(  savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }


  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)

        .build();
  }


  private void saveUserToken(com.ensi.PCD.model.Client client, String jwtToken) {
    var token = Token.builder()
        .client(client)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(com.ensi.PCD.model.Client client) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(client.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public AuthenticationResponse registerVendeur(RegisterVendeurRequest request) {
    var vendeur = com.ensi.PCD.model.Vendeur.builder()
            .idTemplate(request.getIdTemplate())
            .nom(request.getNom())
            .prenom(request.getPrenom())
            .nomboutique(request.getNomboutique())
            .adresse(request.getAdresse())
            .tel(request.getTel())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .fax(request.getFax())
            .role(Role.VENDEUR)
            .build();
    var savedVendeur = vendeurRepository.save(vendeur);
    var jwtToken = jwtService.generateToken(vendeur);
    saveVendeurToken(savedVendeur, jwtToken);
    return AuthenticationResponse.builder()
            .token(jwtToken)

            .build();
  }

  private void saveVendeurToken(com.ensi.PCD.model.Vendeur vendeur, String jwtToken) {
    var token = TokenVendeur.builder()
            .vendeur(vendeur)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
    tokenVendeurRepository.save(token);

  }

  private void revokeAllVendeurTokens(com.ensi.PCD.model.Vendeur vendeur) {
    var validVendeurTokens = tokenVendeurRepository.findAllValidTokenByUser(vendeur.getId());
    if (validVendeurTokens.isEmpty())
      return;
    validVendeurTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenVendeurRepository.saveAll(validVendeurTokens);
  }

  public AuthenticationResponse authenticateVendeur(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var vendeur = vendeurRepository.findByEmail(request.getEmail())
            .orElseThrow();
    var jwtToken = jwtService.generateToken(vendeur);
    revokeAllVendeurTokens(vendeur);
    saveVendeurToken(vendeur, jwtToken);
    return AuthenticationResponse.builder()
            .token(jwtToken)

            .build();
  }

}

