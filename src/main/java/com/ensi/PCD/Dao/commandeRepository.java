package com.ensi.PCD.Dao;
import com.ensi.PCD.model.commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface commandeRepository extends JpaRepository<commande, String> {
    List<commande> findByDateBetween(Date startDate, Date endDate);

}
