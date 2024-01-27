package com.Biblioteka.IT355PZ.Repository;

import com.Biblioteka.IT355PZ.Entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Integer> {
    // Add custom query methods if needed
}