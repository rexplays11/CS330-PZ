package com.Biblioteka.IT355PZ.Repository;

import com.Biblioteka.IT355PZ.Entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    // Add custom query methods if needed
}