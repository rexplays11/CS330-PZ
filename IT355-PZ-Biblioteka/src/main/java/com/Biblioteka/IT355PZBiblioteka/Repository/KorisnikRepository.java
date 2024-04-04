package com.Biblioteka.IT355PZBiblioteka.Repository;

import com.Biblioteka.IT355PZBiblioteka.Entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
}