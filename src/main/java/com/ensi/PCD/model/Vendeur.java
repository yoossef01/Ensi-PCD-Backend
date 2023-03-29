package com.ensi.PCD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_vendeur")
public class Vendeur {

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

}
