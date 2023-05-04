package com.ensi.PCD.model;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class category {
 @Id
 @GeneratedValue(
     strategy = GenerationType.IDENTITY
 )
 private Integer id;
 private String nom;
 @OneToMany(mappedBy = "categorie" ,cascade = CascadeType.ALL)
 @JsonProperty(access = Access.WRITE_ONLY)
 private List<product> produits;
 @ManyToOne
 @JoinColumn(name = "vendeur_id")
 private  Vendeur vendeur;


 public category(String nom) {
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

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
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

 public category(final Integer id, final String nom, final List<product> produits,final Vendeur v) {
     this.id = id;
     this.nom = nom;
     this.produits = produits;
     this.vendeur=v;
 }

 public category() {
 }
}
