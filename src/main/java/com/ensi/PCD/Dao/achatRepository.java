package com.ensi.PCD.Dao;
import com.ensi.PCD.model.achat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface achatRepository extends JpaRepository<achat, String> {
    List<achat> findByDateBetween(Date startDate, Date endDate);

}
