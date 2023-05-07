package com.ensi.PCD.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVendeurRequest {
    private Integer idTemplate;
    private String nom;
    private String prenom;
    private String nomboutique;
    private String adresse;
    private String tel;
    private String email;
    private String password;
    private String fax;

}
