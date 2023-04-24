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
    private String id;
    private String nom;
    private Integer montant;
    private String quantite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private product product;
    @ManyToOne
    @JoinColumn(name = "vendeur_id", nullable = false)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Vendeur vendeur;


}
