package com.ensi.PCD.Dao;

import com.ensi.PCD.model.Client;
import com.ensi.PCD.model.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendeurRepository extends JpaRepository <Vendeur,Integer>{
    Optional<Vendeur> findByEmail(String email);
}
