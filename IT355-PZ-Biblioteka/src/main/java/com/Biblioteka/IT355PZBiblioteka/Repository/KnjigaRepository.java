package com.Biblioteka.IT355PZBiblioteka.Repository;

import com.Biblioteka.IT355PZBiblioteka.Entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Integer> {
}