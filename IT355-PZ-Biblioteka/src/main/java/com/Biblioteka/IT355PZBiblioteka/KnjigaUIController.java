package com.Biblioteka.IT355PZBiblioteka;

import com.Biblioteka.IT355PZBiblioteka.Entity.Autor;
import com.Biblioteka.IT355PZBiblioteka.Entity.IzdavackaKuca;
import com.Biblioteka.IT355PZBiblioteka.Entity.Knjiga;
import com.Biblioteka.IT355PZBiblioteka.Service.AutorService;
import com.Biblioteka.IT355PZBiblioteka.Service.IzdavackaKucaService;
import com.Biblioteka.IT355PZBiblioteka.Service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class KnjigaUIController {

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private IzdavackaKucaService izdavackaKucaService;

    @GetMapping("/knjige")
    public String getAllKnjige(Model model) {
        List<Knjiga> knjige = knjigaService.getAllKnjige();
        model.addAttribute("knjige", knjige);
        return "KnjigaCRUD/knjige";
    }

    @GetMapping("/createKnjiga")
    public String prikaziFormuZaKreiranje(Model model) {
        Knjiga knjiga = new Knjiga();
        model.addAttribute("knjiga", knjiga);

        List<Autor> autori = autorService.getAllAutori();
        model.addAttribute("autori", autori);

        List<IzdavackaKuca> izdavackeKuce = izdavackaKucaService.getAllIzdavackeKuce();
        model.addAttribute("izdavackeKuce", izdavackeKuce);

        return "KnjigaCRUD/new_knjiga";
    }

    @PostMapping("/createKnjiga")
    public String kreirajKnjigu(Knjiga knjiga) {
        knjigaService.createKnjiga(knjiga);
        return "redirect:/knjige";
    }

    @GetMapping("/updateKnjiga/{id}")
    public String prikaziFormuZaAzuriranje(@PathVariable("id") Integer id, Model model) {
        Knjiga knjiga = knjigaService.getKnjigaById(id);
        model.addAttribute("knjiga", knjiga);

        List<Autor> autori = autorService.getAllAutori();
        model.addAttribute("autori", autori);

        List<IzdavackaKuca> izdavackeKuce = izdavackaKucaService.getAllIzdavackeKuce();
        model.addAttribute("izdavackeKuce", izdavackeKuce);

        return "KnjigaCRUD/update_knjiga";
    }

    @PostMapping("/updateKnjiga/{id}")
    public String azurirajKnjigu(@PathVariable("id") Integer id, Knjiga knjiga) {
        knjigaService.updateKnjiga(id, knjiga);
        return "redirect:/knjige";
    }

    @GetMapping("/deleteKnjiga/{id}")
    public String obrisiKnjigu(@PathVariable("id") Integer id) {
        knjigaService.deleteKnjiga(id);
        return "redirect:/knjige";
    }
}