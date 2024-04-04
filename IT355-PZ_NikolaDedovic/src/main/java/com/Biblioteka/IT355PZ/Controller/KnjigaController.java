package com.Biblioteka.IT355PZ.Controller;
import com.Biblioteka.IT355PZ.Entity.Knjiga;
import com.Biblioteka.IT355PZ.Service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Import Controller annotation
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Use @RestController instead of @Controller
@RequestMapping("/api/knjige")
public class KnjigaController {

    private final KnjigaService knjigaService;

    @Autowired
    public KnjigaController(KnjigaService knjigaService) {
        this.knjigaService = knjigaService;
    }

    @GetMapping
    public List<Knjiga> getAllKnjige() {
        return knjigaService.getAllKnjige();
    }

    @GetMapping("/{id}")
    public Knjiga getKnjigaById(@PathVariable Integer id) {
        return knjigaService.getKnjigaById(id);
    }

    @PostMapping
    public Knjiga createKnjiga(@RequestBody Knjiga knjiga) {
        return knjigaService.createKnjiga(knjiga);
    }

    @PutMapping("/{id}")
    public Knjiga updateKnjiga(@PathVariable Integer id, @RequestBody Knjiga knjiga) {
        return knjigaService.updateKnjiga(id, knjiga);
    }

    @DeleteMapping("/{id}")
    public void deleteKnjiga(@PathVariable Integer id) {
        knjigaService.deleteKnjiga(id);
    }

    // No change needed for this method
    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Knjiga> knjigeList = knjigaService.getAllKnjige();
        model.addAttribute("knjigeList", knjigeList);
        return "books"; // Return the template name
    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Ovo je primjer Thymeleaf-a!");
        return "index";
    }
}