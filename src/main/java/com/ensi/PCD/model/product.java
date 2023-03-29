package com.ensi.PCD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by FernFlower decompiler)
//





@Entity
public class product {
 @jakarta.persistence.Id
 private String Id;
 private String nom;
 private String photo;
 private double prix;
 private int quantite;
 private double prix_achat;
 @ManyToOne
 private category categorie;
    @ManyToOne
    private magasin magasin;
 public product(String nom, double prix, category categorie) {
 }

 public product(String string, String nom, int prix, int i, String string2, category c1, int prixAchat) {
     this.Id = string;
     this.nom = nom;
     this.prix = prix;
     this.quantite = i;
     this.photo = string2;
     this.categorie = c1;
     this.prix_achat = prixAchat;
 }

 public String getId() {
     return this.Id;
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

 public void setId(final String Id) {
     this.Id = Id;
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


 public product(final String Id, final String nom, final String photo, final double prix, final int quantite, final double prix_achat, final category categorie) {
     this.Id = Id;
     this.nom = nom;
     this.photo = photo;
     this.prix = prix;
     this.quantite = quantite;
     this.prix_achat = prix_achat;
     this.categorie = categorie;
 }

 public product() {
 }
}
