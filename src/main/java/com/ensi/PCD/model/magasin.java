package com.ensi.PCD.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.List;

@Entity

public class magasin {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String nom;
     @OneToMany(
            mappedBy = "magasin"
    )
    @JsonProperty(
            access =Access.WRITE_ONLY
    )
    private List<product> produits;
    public magasin(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public List<product> getProduits() {
        return this.produits;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    public void setProduits(final List<product> produits) {
        this.produits = produits;
    }

    public magasin(final Integer id, final String nom, final List<product> produits) {
        this.id = id;
        this.nom = nom;
        this.produits = produits;
    }
    public magasin() {
    }

}
