package com.Biblioteka.IT355PZ.Repository;

import com.Biblioteka.IT355PZ.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    // Add custom query methods if needed
}