package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.Korisnik;
import com.Biblioteka.IT355PZBiblioteka.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/")
    public List<Korisnik> getAllKorisnici() {
        return korisnikService.getAllKorisnici();
    }

    @GetMapping("/{id}")
    public Korisnik getKorisnikById(@PathVariable Integer id) {
        return korisnikService.getKorisnikById(id);
    }

    @PostMapping("/")
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik) {
        return korisnikService.createKorisnik(korisnik);
    }

    @PutMapping("/{id}")
    public Korisnik updateKorisnik(@PathVariable Integer id, @RequestBody Korisnik korisnikDetails) {
        return korisnikService.updateKorisnik(id, korisnikDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteKorisnik(@PathVariable Integer id) {
        korisnikService.deleteKorisnik(id);
    }
}