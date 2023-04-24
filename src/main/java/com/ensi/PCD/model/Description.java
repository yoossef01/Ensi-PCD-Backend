package com.ensi.PCD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Description {
    @jakarta.persistence.Id
    private String id;
    private String material;
    private String color;
    private String shortDescription;
    private  String longDescription;
    @OneToOne
    @JoinColumn(name = "product_id")
    private product product;


}
