package com.ensi.PCD.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

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
 private category categorie;
 @ManyToOne
    private magasin magasin;
 @OneToMany

    private List<achat> achats;
 public product(String nom, double prix, category categorie) {
 }

 public product(String string, String nom, int prix, int i, String string2, category c1, int prixAchat,magasin m1) {
     this.id = string;
     this.nom = nom;
     this.prix = prix;
     this.quantite = i;
     this.photo = string2;
     this.categorie = c1;
     this.prix_achat = prixAchat;
     this.magasin=m1;
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
    public magasin getMagasin() {
        return this.magasin;
    }

    public List<achat> getAchats(){return this.achats;}
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
    public void setMagasin(final magasin magasin) {
        this.magasin = magasin;
    }


public void setAchat(final List<achat> a){this.achats=a;}

 public product(final String Id, final String nom, final String photo, final double prix,
                final int quantite, final double prix_achat, final category categorie,final magasin magasin,
 final List<achat> achat) {
     this.id = Id;
     this.nom = nom;
     this.photo = photo;
     this.prix = prix;
     this.quantite = quantite;
     this.prix_achat = prix_achat;
     this.categorie = categorie;
     this.magasin=magasin;
     this.achats= achat;
 }

 public product() {
 }
}
