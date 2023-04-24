package com.ensi.PCD.Dao;

import com.ensi.PCD.model.Description;
import com.ensi.PCD.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DescriptionRepository  extends JpaRepository<Description, String> {
    @Query("select D from Description D where D.product.id=:x")
    Description getDescriptionByProduct(@Param("x") String idProd);
}
