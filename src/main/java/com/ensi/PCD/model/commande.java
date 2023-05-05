package com.ensi.PCD.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class commande {
    @jakarta.persistence.Id
    @GeneratedValue
    private Integer id;
    private double montant;
    private String nom;
    private int quantite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private product product;
    public commande(Integer id,String nom, double m, int q, Date d){
        this.id=id;
        this.nom=nom;
        this.montant=m;
        this.quantite=q;
        this.date=d;

    }

    public String getNom() {
        return nom;
    }

    public Integer getId() {
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
    public void setId(final Integer Id) {
        this.id = Id;
    }
    public void setMontant(final double montant){
        this.montant=montant;
    }
    public void setQuantite(final int quantite){this.quantite=quantite;}
    public void setDate(final Date date){
        this.date=date;
    }

    public Client getClient() {
        return client;
    }

    public  void setProduct(final product product){
        this.product= product;
}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public commande(final Integer id, final String n, final double m, final int q, final Date d, final product p, final  Client c){
       this.id=id;
       this.nom=n;
        this.montant=m;
        this.quantite=q;
        this.date=d;
        this.product=p;
        this.client=c;
    }
    public commande(){}
}
