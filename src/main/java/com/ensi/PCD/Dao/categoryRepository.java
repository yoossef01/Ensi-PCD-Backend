package com.ensi.PCD.Dao;

import com.ensi.PCD.model.category;
import com.ensi.PCD.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoryRepository extends JpaRepository<category, Integer> {
    @Query("select c from category c where c.vendeur.id=:x")
    List<category> getCategoriesByVendeur(@Param("x") Integer idvend);
}
