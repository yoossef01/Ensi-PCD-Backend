package com.ensi.PCD.Dao;


import com.ensi.PCD.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {
}
