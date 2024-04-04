package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.Uloga;
import com.Biblioteka.IT355PZBiblioteka.Service.UlogaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uloge")
public class UlogaController {

    @Autowired
    private UlogaService ulogaService;

    @GetMapping("/")
    public List<Uloga> getAllUloge() {
        return ulogaService.getAllUloge();
    }

    @GetMapping("/{id}")
    public Uloga getUlogaById(@PathVariable Integer id) {
        return ulogaService.getUlogaById(id);
    }

    @PostMapping("/")
    public Uloga createUloga(@RequestBody Uloga uloga) {
        return ulogaService.createUloga(uloga);
    }

    @PutMapping("/{id}")
    public Uloga updateUloga(@PathVariable Integer id, @RequestBody Uloga ulogaDetails) {
        return ulogaService.updateUloga(id, ulogaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUloga(@PathVariable Integer id) {
        ulogaService.deleteUloga(id);
    }
}