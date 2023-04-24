package com.ensi.PCD.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class TemplateContent {
    @jakarta.persistence.Id
    private Integer id;
    private String description;
    private String photo;
    private String text1;
    private String text2;
@OneToOne
@JoinColumn(name = "vendeur_id")
private Vendeur vendeur;


}
