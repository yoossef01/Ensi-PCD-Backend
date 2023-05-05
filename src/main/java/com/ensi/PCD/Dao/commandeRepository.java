package com.ensi.PCD.Dao;
import com.ensi.PCD.model.commande;
import com.ensi.PCD.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface commandeRepository extends JpaRepository<commande, Integer> {
    List<commande> findByDateBetween(Date startDate, Date endDate);
    @Query("select c from commande c where c.client.id=:x")
    List<commande> getCommandesByClient(@Param("x") Integer idClient);
}
