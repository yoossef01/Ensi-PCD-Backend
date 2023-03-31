package com.ensi.PCD.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenVendeurRepository extends JpaRepository<TokenVendeur, Integer> {
    @Query(value = """
      select t from TokenVendeur t inner join Vendeur u\s
      on t.vendeur.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<TokenVendeur> findAllValidTokenByUser(Integer id);

    Optional<TokenVendeur> findByToken(String token);
}
