package com.ensi.PCD.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achat {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private Integer montant;
    private Integer quantite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ManyToOne
    private product product;
    @ManyToOne
    @JoinColumn(name = "vendeur_id")
    private Vendeur vendeur;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private  Client client;
}
