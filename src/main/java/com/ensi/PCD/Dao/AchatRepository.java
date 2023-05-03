package com.ensi.PCD.Dao;

import com.ensi.PCD.model.Achat;
import com.ensi.PCD.model.commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AchatRepository extends JpaRepository<Achat,Integer> {
    List<Achat> findByDateBetween(Date startDate, Date endDate);
    @Query("select p from Achat p where p.vendeur.id=:x")
    List<Achat> getAchatByVendeur(@Param("x") Integer vendeurId);
}
