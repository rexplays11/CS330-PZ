package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Uloga;
import com.Biblioteka.IT355PZBiblioteka.Repository.UlogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UlogaService {

    @Autowired
    private UlogaRepository ulogaRepository;

    public List<Uloga> getAllUloge() {
        return ulogaRepository.findAll();
    }

    public Uloga getUlogaById(Integer id) {
        return ulogaRepository.findById(id).orElse(null);
    }

    public Uloga createUloga(Uloga uloga) {
        return ulogaRepository.save(uloga);
    }

    public Uloga updateUloga(Integer id, Uloga ulogaDetails) {
        Uloga uloga = ulogaRepository.findById(id).orElse(null);
        if (uloga != null) {
            uloga.setImeUlogeKorisnika(ulogaDetails.getImeUlogeKorisnika());
            return ulogaRepository.save(uloga);
        }
        return null;
    }

    public void deleteUloga(Integer id) {
        ulogaRepository.deleteById(id);
    }
}