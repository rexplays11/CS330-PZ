package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.Knjiga;
import com.Biblioteka.IT355PZBiblioteka.Service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knjige")
public class KnjigaController {

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/")
    public List<Knjiga> getAllKnjige() {
        return knjigaService.getAllKnjige();
    }

    @GetMapping("/{id}")
    public Knjiga getKnjigaById(@PathVariable Integer id) {
        return knjigaService.getKnjigaById(id);
    }

    @PostMapping("/")
    public Knjiga createKnjiga(@RequestBody Knjiga knjiga) {
        return knjigaService.createKnjiga(knjiga);
    }

    @PutMapping("/{id}")
    public Knjiga updateKnjiga(@PathVariable Integer id, @RequestBody Knjiga knjigaDetails) {
        return knjigaService.updateKnjiga(id, knjigaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteKnjiga(@PathVariable Integer id) {
        knjigaService.deleteKnjiga(id);
    }
}