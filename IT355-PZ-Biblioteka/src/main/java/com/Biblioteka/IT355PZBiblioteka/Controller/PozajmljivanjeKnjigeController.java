package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.PozajmljivanjeKnjige;
import com.Biblioteka.IT355PZBiblioteka.Service.PozajmljivanjeKnjigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pozajmljivanje_knjige")
public class PozajmljivanjeKnjigeController {

    @Autowired
    private PozajmljivanjeKnjigeService pozajmljivanjeKnjigeService;

    @GetMapping
    public List<PozajmljivanjeKnjige> getAllPozajmljivanja() {
        return pozajmljivanjeKnjigeService.getAllPozajmljivanja();
    }

    @GetMapping("/{id}")
    public PozajmljivanjeKnjige getPozajmljivanjeById(@PathVariable int id) {
        return pozajmljivanjeKnjigeService.getPozajmljivanjeById(id);
    }

    @PostMapping
    public PozajmljivanjeKnjige createPozajmljivanje(@RequestBody PozajmljivanjeKnjige pozajmljivanje) {
        return pozajmljivanjeKnjigeService.createPozajmljivanje(pozajmljivanje);
    }

    @PutMapping("/{id}")
    public void updatePozajmljivanje(@PathVariable int id, @RequestBody PozajmljivanjeKnjige updatedPozajmljivanje) {
        pozajmljivanjeKnjigeService.updatePozajmljivanje(id, updatedPozajmljivanje);
    }

    @DeleteMapping("/{id}")
    public void deletePozajmljivanje(@PathVariable int id) {
        pozajmljivanjeKnjigeService.deletePozajmljivanje(id);
    }
}