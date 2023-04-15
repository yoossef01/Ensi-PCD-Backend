package com.ensi.PCD.model;

import com.ensi.PCD.config.GrantedAuthorityDeserializer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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

public class Vendeur implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer idTemplate;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String password;
    private String fax;
    @Enumerated(EnumType.STRING)
    private RoleVendeur role;

    @OneToMany(mappedBy = "vendeur")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @JsonManagedReference
    private  List<product> produits;

    @OneToMany(mappedBy = "vendeur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Achat> achats;

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
