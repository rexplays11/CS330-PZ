package com.Biblioteka.IT355PZ.Service;

import com.Biblioteka.IT355PZ.Entity.Korisnik;
import com.Biblioteka.IT355PZ.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public List<Korisnik> getAllKorisnici() {
        return korisnikRepository.findAll();
    }

    public Korisnik getKorisnikById(Integer id) {
        return korisnikRepository.findById(id).orElse(null);
    }

    public Korisnik createKorisnik(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public Korisnik updateKorisnik(Integer id, Korisnik korisnik) {
        if (korisnikRepository.existsById(id)) {
            korisnik.setId(id);
            return korisnikRepository.save(korisnik);
        }
        return null; // Handle not found case
    }

    public void deleteKorisnik(Integer id) {
        korisnikRepository.deleteById(id);
    }
}