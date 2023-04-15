package com.ensi.PCD.Dao;

import com.ensi.PCD.model.Achat;
import com.ensi.PCD.model.commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AchatRepository extends JpaRepository<Achat,String> {
    List<Achat> findByDateBetween(Date startDate, Date endDate);

    List<Achat> getAchatByVendeur(Integer vendeurId);
}
