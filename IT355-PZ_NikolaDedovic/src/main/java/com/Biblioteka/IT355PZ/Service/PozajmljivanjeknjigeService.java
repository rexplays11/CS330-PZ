package com.Biblioteka.IT355PZ.Service;

import com.Biblioteka.IT355PZ.Entity.Pozajmljivanjeknjige;
import com.Biblioteka.IT355PZ.Entity.PozajmljivanjeknjigeId;
import com.Biblioteka.IT355PZ.Repository.PozajmljivanjeknjigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PozajmljivanjeknjigeService {

    private final PozajmljivanjeknjigeRepository pozajmljivanjeknjigeRepository;

    @Autowired
    public PozajmljivanjeknjigeService(PozajmljivanjeknjigeRepository pozajmljivanjeknjigeRepository) {
        this.pozajmljivanjeknjigeRepository = pozajmljivanjeknjigeRepository;
    }

    public List<Pozajmljivanjeknjige> getAllPozajmljivanja() {
        return pozajmljivanjeknjigeRepository.findAll();
    }

    public Pozajmljivanjeknjige getPozajmljivanjeById(PozajmljivanjeknjigeId id) {
        return pozajmljivanjeknjigeRepository.findById(id).orElse(null);
    }

    public Pozajmljivanjeknjige createPozajmljivanje(Pozajmljivanjeknjige pozajmljivanje) {
        return pozajmljivanjeknjigeRepository.save(pozajmljivanje);
    }

    public Pozajmljivanjeknjige updatePozajmljivanje(PozajmljivanjeknjigeId id, Pozajmljivanjeknjige pozajmljivanje) {
        if (pozajmljivanjeknjigeRepository.existsById(id)) {
            pozajmljivanje.setId(id);
            return pozajmljivanjeknjigeRepository.save(pozajmljivanje);
        }
        return null; // Handle not found case
    }

    public void deletePozajmljivanje(PozajmljivanjeknjigeId id) {
        pozajmljivanjeknjigeRepository.deleteById(id);
    }
}