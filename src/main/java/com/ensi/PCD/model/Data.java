package com.ensi.PCD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotes_tb")
public class Data {
    @Id
    @GeneratedValue
    private String product_nom;
    private String product_prix;
}
