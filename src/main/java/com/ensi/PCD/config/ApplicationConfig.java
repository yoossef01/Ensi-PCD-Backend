package com.ensi.PCD.config;

import com.ensi.PCD.Dao.UserRepository;
import com.ensi.PCD.Dao.VendeurRepository;
import com.ensi.PCD.model.Vendeur;
import com.ensi.PCD.model.Client;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserRepository repository;

  private final VendeurRepository vendeurRepository;
  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      Optional<Client> client = repository.findByEmail(username);
      Optional<Vendeur> vendeur = vendeurRepository.findByEmail(username);

      if (client.isPresent()) {
        return client.get();
      } else if (vendeur.isPresent()) {
        return vendeur.get();
      } else {
        throw new UsernameNotFoundException("User not found");
      }
    };
  }
  @Bean
  public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder);
    return authProvider;}

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}


