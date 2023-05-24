package com.ensi.PCD.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//





@Entity
public class product {
 @jakarta.persistence.Id
 private String id;
 private String nom;
 private String photo;
 private double prix;
 private int quantite;
 private double prix_achat;
 @ManyToOne
 @JoinColumn(name = "categorie_id")
 private category categorie;

 @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
 private List<commande> commandes;
 @ManyToOne
 @JoinColumn(name = "vendeur_id")
private  Vendeur vendeur;
@OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private List<Achat> achats;

@OneToOne (mappedBy = "product")
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private ProductToCompare productToCompare;

@OneToOne (mappedBy = "product" ,cascade = CascadeType.ALL)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Description description;
public product(String nom, double prix, category categorie) {
 }

 public product(String string, String nom, int prix, int i, String string2, category c1, int prixAchat,Vendeur v) {
     this.id = string;
     this.nom = nom;
     this.prix = prix;
     this.quantite = i;
     this.photo = string2;
     this.categorie = c1;
     this.prix_achat = prixAchat;
     this.vendeur=v;
 }

 public String getId() {
     return this.id;
 }

 public String getNom() {
     return this.nom;
 }

 public String getPhoto() {
     return this.photo;
 }

 public double getPrix() {
     return this.prix;
 }

 public int getQuantite() {
     return this.quantite;
 }

 public double getPrix_achat() {
     return this.prix_achat;
 }

 public category getCategorie() {
     return this.categorie;
 }
    public Vendeur getVendeur() {
        return this.vendeur;
    }

    public List<commande> getCommandes(){return this.commandes;}
 public void setId(final String Id) {
     this.id = Id;
 }

 public void setNom(final String nom) {
     this.nom = nom;
 }

 public void setPhoto(final String photo) {
     this.photo = photo;
 }

 public void setPrix(final double prix) {
     this.prix = prix;
 }

 public void setQuantite(final int quantite) {
     this.quantite = quantite;
 }

 public void setPrix_achat(final double prix_achat) {
     this.prix_achat = prix_achat;
 }

 public void setCategorie(final category categorie) {
     this.categorie = categorie;
 }
    public void setVendeur(final Vendeur v) {
        this.vendeur = v;
    }


public void setCommandes(final List<commande> a){this.commandes =a;}

 public product(final String Id, final String nom, final String photo, final double prix,
                final int quantite, final double prix_achat, final category categorie,final Vendeur v,
 final List<commande> commande) {
     this.id = Id;
     this.nom = nom;
     this.photo = photo;
     this.prix = prix;
     this.quantite = quantite;
     this.prix_achat = prix_achat;
     this.categorie = categorie;
     this.vendeur=v;
     this.commandes = commande;
 }

 public product() {
 }
}
