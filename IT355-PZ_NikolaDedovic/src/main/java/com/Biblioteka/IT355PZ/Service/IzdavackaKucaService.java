package com.Biblioteka.IT355PZ.Service;

import com.Biblioteka.IT355PZ.Entity.IzdavackaKuca;
import com.Biblioteka.IT355PZ.Repository.IzdavackaKucaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzdavackaKucaService {

    private final IzdavackaKucaRepository izdavackaKucaRepository;

    @Autowired
    public IzdavackaKucaService(IzdavackaKucaRepository izdavackaKucaRepository) {
        this.izdavackaKucaRepository = izdavackaKucaRepository;
    }

    public List<IzdavackaKuca> getAllIzdavackaKuce() {
        return izdavackaKucaRepository.findAll();
    }

    public IzdavackaKuca getIzdavackaKucaById(Integer id) {
        return izdavackaKucaRepository.findById(id).orElse(null);
    }

    public IzdavackaKuca createIzdavackaKuca(IzdavackaKuca izdavackaKuca) {
        return izdavackaKucaRepository.save(izdavackaKuca);
    }

    public IzdavackaKuca updateIzdavackaKuca(Integer id, IzdavackaKuca izdavackaKuca) {
        if (izdavackaKucaRepository.existsById(id)) {
            izdavackaKuca.setId(id);
            return izdavackaKucaRepository.save(izdavackaKuca);
        }
        return null; // Handle not found case
    }

    public void deleteIzdavackaKuca(Integer id) {
        izdavackaKucaRepository.deleteById(id);
    }
}