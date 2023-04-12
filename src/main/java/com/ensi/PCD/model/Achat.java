package com.ensi.PCD.model;

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
    private String id;
    private String nom;
    private String montant;
    private String quantite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ManyToOne
    private product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendeur_id", nullable = false)
    private Vendeur vendeur;


}
