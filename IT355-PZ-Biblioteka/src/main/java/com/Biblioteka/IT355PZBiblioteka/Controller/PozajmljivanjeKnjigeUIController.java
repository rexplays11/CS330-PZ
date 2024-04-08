package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.Knjiga;
import com.Biblioteka.IT355PZBiblioteka.Entity.Korisnik;
import com.Biblioteka.IT355PZBiblioteka.Entity.PozajmljivanjeKnjige;
import com.Biblioteka.IT355PZBiblioteka.Service.KnjigaService;
import com.Biblioteka.IT355PZBiblioteka.Service.KorisnikService;
import com.Biblioteka.IT355PZBiblioteka.Service.PozajmljivanjeKnjigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PozajmljivanjeKnjigeUIController {

    @Autowired
    private PozajmljivanjeKnjigeService pozajmljivanjeKnjigeService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KnjigaService knjigaService;
    @GetMapping("/pozajmljivanje_knjige")
    public String prikaziSvaPozajmljivanja(Model model) {
        List<PozajmljivanjeKnjige> pozajmljivanja = pozajmljivanjeKnjigeService.getAllPozajmljivanja();
        model.addAttribute("pozajmljivanja", pozajmljivanja);
        return "Pozamljivanje_knjigeCRUD/pozajmljivanje_knjige";
    }

    @GetMapping("/createPozajmljivanje")
    public String prikaziFormuZaKreiranje(Model model) {
        PozajmljivanjeKnjige pozajmljivanje = new PozajmljivanjeKnjige();
        model.addAttribute("pozajmljivanje", pozajmljivanje);

        List<Korisnik> korisnici = korisnikService.getAllKorisnici();
        model.addAttribute("korisnici", korisnici);

        List<Knjiga> knjige = knjigaService.getAllKnjige();
        model.addAttribute("knjige", knjige);

        return "Pozamljivanje_knjigeCRUD/new_pozajmljivanje_knjige";
    }

    @PostMapping("/createPozajmljivanje")
    public String kreirajPozajmljivanje(PozajmljivanjeKnjige pozajmljivanje) {
        pozajmljivanjeKnjigeService.createPozajmljivanje(pozajmljivanje);
        return "redirect:/pozajmljivanje_knjige";
    }

    @GetMapping("/updatePozajmljivanje/{id}")
    public String prikaziFormuZaAzuriranje(@PathVariable("id") Integer id, Model model) {
        PozajmljivanjeKnjige pozajmljivanje = pozajmljivanjeKnjigeService.getPozajmljivanjeById(id);
        model.addAttribute("pozajmljivanje", pozajmljivanje);

        List<Korisnik> korisnici = korisnikService.getAllKorisnici();
        model.addAttribute("korisnici", korisnici);

        List<Knjiga> knjige = knjigaService.getAllKnjige();
        model.addAttribute("knjige", knjige);
        return "Pozamljivanje_knjigeCRUD/update_pozajmljivanje_knjige";
    }

    @PostMapping("/updatePozajmljivanje/{id}")
    public String azurirajPozajmljivanje(@PathVariable("id") Integer id, PozajmljivanjeKnjige pozajmljivanje) {
        pozajmljivanjeKnjigeService.updatePozajmljivanje(id, pozajmljivanje);
        return "redirect:/pozajmljivanje_knjige";
    }

    @GetMapping("/deletePozajmljivanje/{id}")
    public String obrisiPozajmljivanje(@PathVariable("id") Integer id) {
        pozajmljivanjeKnjigeService.deletePozajmljivanje(id);
        return "redirect:/pozajmljivanje_knjige";
    }

    @GetMapping("/korisnici/{id}")
    public String prikaziKorisnika(@PathVariable("id") Integer id, Model model) {
        Korisnik korisnik = korisnikService.getKorisnikById(id);
        model.addAttribute("korisnik", korisnik);
        return "KorisnikCRUD/prikazi_korisnika";
    }
    @GetMapping("/knjiga/{id}")
    public String prikaziKnjigu(@PathVariable("id") Integer id, Model model) {
        Knjiga knjiga = knjigaService.getKnjigaById(id);
        model.addAttribute("knjiga", knjiga);
        return "KnjigaCRUD/prikazi_knjigu";
    }
    @PostMapping("/buyBook")
    public String buyBook(@RequestParam("idKnjiga") Integer idKnjiga,
                          @RequestParam("idKorisnika") Integer idKorisnika,
                          @RequestParam("datum") LocalDate datum) {


        Knjiga knjiga = knjigaService.getKnjigaById(idKnjiga);

        if (knjiga.getKolicina() > 0) {

            knjiga.setKolicina(knjiga.getKolicina() - 1);


            knjigaService.updateKnjiga(idKnjiga, knjiga);


            PozajmljivanjeKnjige pozajmljivanje = new PozajmljivanjeKnjige();
            pozajmljivanje.setIdKorisnika(idKorisnika);
            pozajmljivanje.setIdKnjige(idKnjiga);
            pozajmljivanje.setDatumIznamljivanja(datum);


            pozajmljivanjeKnjigeService.createPozajmljivanje(pozajmljivanje);
        } else {
            return "redirect:/error";
        }

        return "redirect:/knjige";
    }
}