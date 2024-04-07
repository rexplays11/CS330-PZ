package com.Biblioteka.IT355PZBiblioteka;


import com.Biblioteka.IT355PZBiblioteka.Entity.Korisnik;
import com.Biblioteka.IT355PZBiblioteka.Entity.Uloga;
import com.Biblioteka.IT355PZBiblioteka.Service.KorisnikService;
import com.Biblioteka.IT355PZBiblioteka.Service.UlogaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KorisnikUIController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private UlogaService ulogaService;

    @GetMapping("/korisnici")
    public String prikaziSveKorisnike(Model model) {
        List<Korisnik> korisnici = korisnikService.getAllKorisnici();
        model.addAttribute("korisnici", korisnici);
        return "KorisnikCRUD/korisnici";
    }

    @GetMapping("/createKorisnik")
    public String prikaziFormuZaKreiranje(Model model) {
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);

        List<Uloga> uloge = ulogaService.getAllUloge();
        model.addAttribute("uloge", uloge);

        return "KorisnikCRUD/new_korisnik";
    }

    @PostMapping("/createKorisnik")
    public String kreirajKorisnika(Korisnik korisnik) {
        korisnikService.createKorisnik(korisnik);
        return "redirect:/korisnici";
    }

    @GetMapping("/updateKorisnik/{id}")
    public String prikaziFormuZaAzuriranje(@PathVariable("id") Integer id, Model model) {
        Korisnik korisnik = korisnikService.getKorisnikById(id);
        model.addAttribute("korisnik", korisnik);
        List<Uloga> uloge = ulogaService.getAllUloge();
        model.addAttribute("uloge", uloge);
        return "KorisnikCRUD/update_korisnik";
    }

    @PostMapping("/updateKorisnik/{id}")
    public String azurirajKorisnika(@PathVariable("id") Integer id, Korisnik korisnik) {
        korisnikService.updateKorisnik(id, korisnik);
        return "redirect:/korisnici";
    }

    @GetMapping("/deleteKorisnik/{id}")
    public String obrisiKorisnika(@PathVariable("id") Integer id) {
        korisnikService.deleteKorisnik(id);
        return "redirect:/korisnici";
    }

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String prikaziLoginFormu(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "login";
    }

    @PostMapping("/doLogin")
    public String login(Korisnik korisnik, Model model) {
        // Provera korisnika u bazi
        Korisnik ulogovaniKorisnik = korisnikService.getKorisnikByNazivAndLozinka(korisnik.getNaziv(), korisnik.getLozinka());

        if (ulogovaniKorisnik != null) {
            // Postavljanje korisnika u sesiju
            session.setAttribute("ulogovaniKorisnik", ulogovaniKorisnik);
            model.addAttribute("korisnik", ulogovaniKorisnik);
            System.out.println(session.getId());
            return "userDetails";
        } else {
            model.addAttribute("error", "Pogrešan naziv ili lozinka.");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String odjaviKorisnika(HttpSession session) {

        session.removeAttribute("ulogovaniKorisnik");

     session.invalidate();
        return "redirect:/login";
    }
}
