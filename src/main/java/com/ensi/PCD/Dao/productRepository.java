package com.ensi.PCD.Dao;


import com.ensi.PCD.model.product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product, String> {
    @Query("select p from product p where p.categorie.id=:x")
    List<product> getProductsByCate(@Param("x") Integer cat);
}
