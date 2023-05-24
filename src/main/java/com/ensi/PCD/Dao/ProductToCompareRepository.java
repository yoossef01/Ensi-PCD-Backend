package com.ensi.PCD.Dao;
import com.ensi.PCD.model.ProductToCompare;
import com.ensi.PCD.model.commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductToCompareRepository extends JpaRepository<ProductToCompare, Integer> {
    @Query("select p from ProductToCompare p where p.client.id=:x")
    List<ProductToCompare> getAllProductToComparesByClient(@Param("x") Integer idClient);
}
