package com.Biblioteka.IT355PZBiblioteka.Repository;

import com.Biblioteka.IT355PZBiblioteka.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}