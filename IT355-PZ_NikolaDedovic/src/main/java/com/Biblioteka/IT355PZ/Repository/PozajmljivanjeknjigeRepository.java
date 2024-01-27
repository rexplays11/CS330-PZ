package com.Biblioteka.IT355PZ.Repository;

import com.Biblioteka.IT355PZ.Entity.Pozajmljivanjeknjige;
import com.Biblioteka.IT355PZ.Entity.PozajmljivanjeknjigeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PozajmljivanjeknjigeRepository extends JpaRepository<Pozajmljivanjeknjige, PozajmljivanjeknjigeId> {
    // Add custom query methods if needed
}
