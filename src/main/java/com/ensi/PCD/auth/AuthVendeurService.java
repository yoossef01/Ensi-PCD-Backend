package com.ensi.PCD.auth;


import com.ensi.PCD.Dao.VendeurRepository;
import com.ensi.PCD.config.JwtService;
import com.ensi.PCD.model.RoleVendeur;
import com.ensi.PCD.token.TokenVendeur;
import com.ensi.PCD.token.TokenType;
import com.ensi.PCD.token.TokenVendeurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthVendeurService {
    private final VendeurRepository repository;
    private final TokenVendeurRepository tokenVendeurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterVendeurRequest vendeurRequest) {
        var vendeur = com.ensi.PCD.model.Vendeur.builder()
                .idTemplate(vendeurRequest.getIdTemplate())
                .nom(vendeurRequest.getNom())
                .prenom(vendeurRequest.getPrenom())
                .adresse(vendeurRequest.getAddresse())
                .tel(vendeurRequest.getTel())
                .email(vendeurRequest.getEmail())
                .password(passwordEncoder.encode(vendeurRequest.getPassword()))
                .fax(vendeurRequest.getFax())
                .role(RoleVendeur.USER)
                .build();
        var savedVendeur = repository.save(vendeur);
        var jwtToken = jwtService.generateToken(vendeur);
        saveVendeurToken(savedVendeur, jwtToken);
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
        var vendeur = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(vendeur);
        revokeAllVendeurTokens(vendeur);
        saveVendeurToken(vendeur, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveVendeurToken(com.ensi.PCD.model.Vendeur vendeur, String jwtToken) {
        var token = TokenVendeur.builder()
                .Vendeur(vendeur)
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
}
