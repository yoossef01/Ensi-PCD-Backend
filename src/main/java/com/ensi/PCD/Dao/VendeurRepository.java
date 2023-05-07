package com.ensi.PCD.Dao;


import com.ensi.PCD.model.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VendeurRepository extends JpaRepository <Vendeur,Integer>{
    @Query("select c from Vendeur c where c.email=:x")
    Optional<Vendeur> findByEmail(@Param("x") String email);
    @Query("select c from Vendeur c where c.nomboutique=:x")
    Optional<Vendeur> findByNomboutique(@Param("x") String nomboutique);
}
