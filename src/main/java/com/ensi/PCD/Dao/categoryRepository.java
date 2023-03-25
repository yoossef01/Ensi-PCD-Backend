package com.ensi.PCD.Dao;

import com.ensi.PCD.model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<category, Integer> {
}
