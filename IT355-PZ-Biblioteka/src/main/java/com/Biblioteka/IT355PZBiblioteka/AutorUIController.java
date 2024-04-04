package com.Biblioteka.IT355PZBiblioteka;

import com.Biblioteka.IT355PZBiblioteka.Entity.Autor;
import com.Biblioteka.IT355PZBiblioteka.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AutorUIController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autori")
    public String prikaziSveAutore(Model model) {
        List<Autor> autori = autorService.getAllAutori();
        model.addAttribute("autori", autori);
        return "AutorCRUD/autori";
    }

    @GetMapping("/createAutor")
    public String prikaziFormuZaKreiranje(Model model) {
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "AutorCRUD/new_autor";
    }

    @PostMapping("/createAutor")
    public String kreirajAutora(Autor autor) {
        autorService.createAutor(autor);
        return "redirect:/autori";
    }

    @GetMapping("/updateAutor/{id}")
    public String prikaziFormuZaAzuriranje(@PathVariable("id") Integer id, Model model) {
        Autor autor = autorService.getAutorById(id);
        model.addAttribute("autor", autor);
        return "AutorCRUD/update_autor";
    }

    @PostMapping("/updateAutor/{id}")
    public String azurirajAutora(@PathVariable("id") Integer id, Autor autor) {
        autorService.updateAutor(id, autor);
        return "redirect:/autori";
    }

    @GetMapping("/deleteAutor/{id}")
    public String obrisiAutora(@PathVariable("id") Integer id) {
        autorService.deleteAutor(id);
        return "redirect:/autori";
    }
}