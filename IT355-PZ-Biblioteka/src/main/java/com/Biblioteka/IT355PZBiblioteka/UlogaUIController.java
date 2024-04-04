package com.Biblioteka.IT355PZBiblioteka;

import com.Biblioteka.IT355PZBiblioteka.Entity.Uloga;
import com.Biblioteka.IT355PZBiblioteka.Service.UlogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UlogaUIController {

    @Autowired
    private UlogaService ulogaService;

    @GetMapping("/uloge")
    public String prikaziSveUloge(Model model) {
        List<Uloga> uloge = ulogaService.getAllUloge();
        model.addAttribute("uloge", uloge);
        return "UlogaCRUD/uloge";
    }

    @GetMapping("/createUloga")
    public String prikaziFormuZaKreiranjeUloge(Model model) {
        Uloga uloga = new Uloga();
        model.addAttribute("uloga", uloga);
        return "UlogaCRUD/new_uloga";
    }

    @PostMapping("/createUloga")
    public String kreirajUlogu(Uloga uloga) {
        ulogaService.createUloga(uloga);
        return "redirect:/uloge";
    }

    @GetMapping("/updateUloga/{id}")
    public String prikaziFormuZaAzuriranjeUloge(@PathVariable("id") Integer id, Model model) {
        Uloga uloga = ulogaService.getUlogaById(id);
        model.addAttribute("uloga", uloga);
        return "UlogaCRUD/update_uloga";
    }

    @PostMapping("/updateUloga/{id}")
    public String azurirajUlogu(@PathVariable("id") Integer id, Uloga uloga) {
        ulogaService.updateUloga(id, uloga);
        return "redirect:/uloge";
    }

    @GetMapping("/deleteUloga/{id}")
    public String obrisiUlogu(@PathVariable("id") Integer id) {
        ulogaService.deleteUloga(id);
        return "redirect:/uloge";
    }
}