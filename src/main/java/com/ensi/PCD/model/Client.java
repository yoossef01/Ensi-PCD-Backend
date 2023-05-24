package com.ensi.PCD.model;

import com.ensi.PCD.token.Token;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "_client")
public class Client implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id;
  private String nom;
  private String prenom;
  private String adresse;
  private String tel;
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;


  @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL)
  @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
  private List<Token> tokens;

  @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL)
  @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
  private  List<Achat> achats;

  @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL)
  @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
  private  List<ProductToCompare> productToCompare;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }
  public Client(String nom, String prenom, String adresse, String tel, String email, String password, Role role) {
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.tel = tel;
    this.email = email;
    this.password = password;
    this.role = role;
  }
  public  String getNom(){return  this.nom;}

  public String getPrenom() {
    return prenom;
  }

  public Integer getId() {
    return id;
  }

  public Role getRole() {
    return role;
  }

  public String getAdresse() {
    return adresse;
  }

  public String getEmail() {
    return email;
  }

  public String getTel() {
    return tel;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void setTel(String tel) {
    this.tel = tel;
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
}
