package com.ensi.PCD.model;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class commande {
    @jakarta.persistence.Id
    private String id;
    private double montant;
    private int quantite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

            //(fetch = FetchType.LAZY)

    @ManyToOne
    private product product;
    public commande(String id, double m, int q, Date d){
        this.id=id;
        this.montant=m;
        this.quantite=q;
        this.date=d;

    }

    public String getId() {
        return this.id;
    }
    public double getMontant(){
        return this.montant;
    }
    public int getQuantite(){return this.quantite;}
    public Date getDate(){
        return  this.date;
    }
    public product getProduct(){
        return this.product;
    }
    public void setId(final String Id) {
        this.id = Id;
    }
    public void setMontant(final double montant){
        this.montant=montant;
    }
    public void setQuantite(final int quantite){this.quantite=quantite;}
    public void setDate(final Date date){
        this.date=date;
    }
public  void setProduct(final product product){
        this.product= product;
}
    public commande(final String id, final double m, final int q, final Date d, final product p){
       this.id=id;
        this.montant=m;
        this.quantite=q;
        this.date=d;
        this.product=p;
    }
    public commande(){}
}
