package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.PozajmljivanjeKnjige;
import com.Biblioteka.IT355PZBiblioteka.Repository.PozajmljivanjeKnjigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PozajmljivanjeKnjigeService {

    @Autowired
    private PozajmljivanjeKnjigeRepository pozajmljivanjeKnjigeRepository;

    public List<PozajmljivanjeKnjige> getAllPozajmljivanja() {
        return pozajmljivanjeKnjigeRepository.findAll();
    }

    public PozajmljivanjeKnjige getPozajmljivanjeById(int id) {
        return pozajmljivanjeKnjigeRepository.findById(id).orElse(null);
    }

    public PozajmljivanjeKnjige createPozajmljivanje(PozajmljivanjeKnjige pozajmljivanje) {
        return pozajmljivanjeKnjigeRepository.save(pozajmljivanje);
    }

    public void updatePozajmljivanje(int id, PozajmljivanjeKnjige updatedPozajmljivanje) {
        PozajmljivanjeKnjige pozajmljivanje = getPozajmljivanjeById(id);
        if (pozajmljivanje != null) {
            pozajmljivanje.setIdKorisnika(updatedPozajmljivanje.getIdKorisnika());
            pozajmljivanje.setIdKnjige(updatedPozajmljivanje.getIdKnjige());
            pozajmljivanje.setBrojKnjiga(updatedPozajmljivanje.getBrojKnjiga());
            pozajmljivanje.setDatumIznamljivanja(updatedPozajmljivanje.getDatumIznamljivanja());
            pozajmljivanjeKnjigeRepository.save(pozajmljivanje);
        }
    }

    public void deletePozajmljivanje(int id) {
        pozajmljivanjeKnjigeRepository.deleteById(id);
    }
}