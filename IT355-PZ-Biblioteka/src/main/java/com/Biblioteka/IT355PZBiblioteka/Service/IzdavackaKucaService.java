package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.IzdavackaKuca;
import com.Biblioteka.IT355PZBiblioteka.Repository.IzdavackaKucaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzdavackaKucaService {

    @Autowired
    private IzdavackaKucaRepository izdavackaKucaRepository;

    public List<IzdavackaKuca> getAllIzdavackeKuce() {
        return izdavackaKucaRepository.findAll();
    }

    public IzdavackaKuca getIzdavackaKucaById(Integer id) {
        return izdavackaKucaRepository.findById(id).orElse(null);
    }

    public IzdavackaKuca createIzdavackaKuca(IzdavackaKuca izdavackaKuca) {
        return izdavackaKucaRepository.save(izdavackaKuca);
    }

    public IzdavackaKuca updateIzdavackaKuca(Integer id, IzdavackaKuca izdavackaKucaDetails) {
        IzdavackaKuca izdavackaKuca = izdavackaKucaRepository.findById(id).orElse(null);
        if (izdavackaKuca != null) {
            izdavackaKuca.setNazivIzdavackeKuce(izdavackaKucaDetails.getNazivIzdavackeKuce());
            return izdavackaKucaRepository.save(izdavackaKuca);
        }
        return null;
    }

    public void deleteIzdavackaKuca(Integer id) {
        izdavackaKucaRepository.deleteById(id);
    }
}