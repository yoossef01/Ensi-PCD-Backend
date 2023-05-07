package com.ensi.PCD.model;

import com.ensi.PCD.config.GrantedAuthorityDeserializer;


import com.fasterxml.jackson.annotation.*;
import com.ensi.PCD.token.Token;
import com.ensi.PCD.token.TokenVendeur;


import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_vendeur")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"enabled"})
public class Vendeur implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer idTemplate;
    private String nom;
    private String prenom;
    private String nomboutique;
    private String adresse;
    private String tel;
    private String email;
    private String password;
    private String fax;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "vendeur" ,cascade = CascadeType.ALL)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private  List<product> produits;
    @OneToMany(mappedBy = "vendeur" ,cascade = CascadeType.ALL)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private  List<category> categories;

    @OneToMany(mappedBy = "vendeur" ,cascade = CascadeType.ALL)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<Achat> achats;


    @OneToMany(mappedBy = "vendeur" ,cascade = CascadeType.ALL)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<TokenVendeur> tokens;

    @OneToOne(mappedBy = "vendeur" ,cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TemplateContent templateContent;

    @Override
    @JsonDeserialize(using = GrantedAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setIdTemplate(Integer idTemplate) {
        this.idTemplate = idTemplate;
    }
}
