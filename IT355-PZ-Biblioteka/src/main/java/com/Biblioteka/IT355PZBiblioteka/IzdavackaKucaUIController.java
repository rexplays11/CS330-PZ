package com.Biblioteka.IT355PZBiblioteka;

import com.Biblioteka.IT355PZBiblioteka.Entity.IzdavackaKuca;
import com.Biblioteka.IT355PZBiblioteka.Service.IzdavackaKucaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IzdavackaKucaUIController {

    @Autowired
    private IzdavackaKucaService izdavackaKucaService;

    @GetMapping("/izdavacke-kuce")
    public String prikaziSveIzdavackeKuce(Model model) {
        List<IzdavackaKuca> izdavackeKuce = izdavackaKucaService.getAllIzdavackeKuce();
        model.addAttribute("izdavackeKuce", izdavackeKuce);
        return "Izdavacka_kucaCRUD/izdavacke_kuce";
    }

    @GetMapping("/createIzdavackaKuca")
    public String prikaziFormuZaKreiranje(Model model) {
        IzdavackaKuca izdavackaKuca = new IzdavackaKuca();
        model.addAttribute("izdavackaKuca", izdavackaKuca);
        return "Izdavacka_kucaCRUD/new_izdavacka_kuca";
    }

    @PostMapping("/createIzdavackaKuca")
    public String kreirajIzdavackuKucu(IzdavackaKuca izdavackaKuca) {
        izdavackaKucaService.createIzdavackaKuca(izdavackaKuca);
        return "redirect:/izdavacke-kuce";
    }

    @GetMapping("/updateIzdavackaKuca/{id}")
    public String prikaziFormuZaAzuriranje(@PathVariable("id") Integer id, Model model) {
        IzdavackaKuca izdavackaKuca = izdavackaKucaService.getIzdavackaKucaById(id);
        model.addAttribute("izdavackaKuca", izdavackaKuca);
        return "Izdavacka_kucaCRUD/update_izdavacka_kuca";
    }

    @PostMapping("/updateIzdavackaKuca/{id}")
    public String azurirajIzdavackuKucu(@PathVariable("id") Integer id, IzdavackaKuca izdavackaKuca) {
        izdavackaKucaService.updateIzdavackaKuca(id, izdavackaKuca);
        return "redirect:/izdavacke-kuce";
    }

    @GetMapping("/deleteIzdavackaKuca/{id}")
    public String obrisiIzdavackuKucu(@PathVariable("id") Integer id) {
        izdavackaKucaService.deleteIzdavackaKuca(id);
        return "redirect:/izdavacke-kuce";
    }
}