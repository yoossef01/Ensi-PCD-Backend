package com.ensi.PCD.Dao;

import com.ensi.PCD.model.TemplateContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TemplateContentRepository extends JpaRepository<TemplateContent, Integer> {
    @Query("select t from TemplateContent t where t.vendeur.id=:x")
    TemplateContent getTemplateByVendeur(@Param("x") Integer idVend);
}
