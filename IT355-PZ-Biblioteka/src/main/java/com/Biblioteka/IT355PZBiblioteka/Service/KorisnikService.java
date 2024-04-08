package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Korisnik;
import com.Biblioteka.IT355PZBiblioteka.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

public interface KorisnikService {
    List<Korisnik> getAllKorisnici();
    Korisnik getKorisnikById(Integer id);
    Korisnik createKorisnik(Korisnik korisnik);
    Korisnik updateKorisnik(Integer id, Korisnik korisnikDetails);
    Korisnik getKorisnikByNazivAndLozinka(String naziv, String lozinka);
    void deleteKorisnik(Integer id);
}