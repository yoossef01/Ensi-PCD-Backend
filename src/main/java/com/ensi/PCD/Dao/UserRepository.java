package com.ensi.PCD.Dao;

import com.ensi.PCD.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Client, Integer> {

  Optional<Client> findByEmail(String email);

}
