package com.Biblioteka.IT355PZ.Repository;

import com.Biblioteka.IT355PZ.Entity.IzdavackaKuca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IzdavackaKucaRepository extends JpaRepository<IzdavackaKuca, Integer> {
    // Add custom query methods if needed
}