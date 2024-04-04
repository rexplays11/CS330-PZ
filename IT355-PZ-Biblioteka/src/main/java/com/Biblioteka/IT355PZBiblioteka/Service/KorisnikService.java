package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Korisnik;
import com.Biblioteka.IT355PZBiblioteka.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> getAllKorisnici() {
        return korisnikRepository.findAll();
    }

    public Korisnik getKorisnikById(Integer id) {
        return korisnikRepository.findById(id).orElse(null);
    }

    public Korisnik createKorisnik(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public Korisnik updateKorisnik(Integer id, Korisnik korisnikDetails) {
        Korisnik korisnik = korisnikRepository.findById(id).orElse(null);
        if (korisnik != null) {
            korisnik.setIme(korisnikDetails.getIme());
            korisnik.setPrezime(korisnikDetails.getPrezime());
            korisnik.setNaziv(korisnikDetails.getNaziv());
            korisnik.setEmail(korisnikDetails.getEmail());
            korisnik.setIdUloge(korisnikDetails.getIdUloge());
            return korisnikRepository.save(korisnik);
        }
        return null;
    }

    public void deleteKorisnik(Integer id) {
        korisnikRepository.deleteById(id);
    }
}