package com.Biblioteka.IT355PZ.Controller;

import com.Biblioteka.IT355PZ.Entity.Pozajmljivanjeknjige;
import com.Biblioteka.IT355PZ.Entity.PozajmljivanjeknjigeId;
import com.Biblioteka.IT355PZ.Service.PozajmljivanjeknjigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pozajmljivanja")
public class PozajmljivanjeknjigeController {

    private final PozajmljivanjeknjigeService pozajmljivanjeService;

    @Autowired
    public PozajmljivanjeknjigeController(PozajmljivanjeknjigeService pozajmljivanjeService) {
        this.pozajmljivanjeService = pozajmljivanjeService;
    }

    @GetMapping
    public List<Pozajmljivanjeknjige> getAllPozajmljivanja() {
        return pozajmljivanjeService.getAllPozajmljivanja();
    }

    @GetMapping("/{idKorisnika}/{idKnjige}")
    public Pozajmljivanjeknjige getPozajmljivanjeById(@PathVariable Integer idKorisnika, @PathVariable Integer idKnjige) {
        PozajmljivanjeknjigeId id = new PozajmljivanjeknjigeId();
        id.setIdKorisnika(idKorisnika);
        id.setIdKnjige(idKnjige);
        return pozajmljivanjeService.getPozajmljivanjeById(id);
    }

    @PostMapping
    public Pozajmljivanjeknjige createPozajmljivanje(@RequestBody Pozajmljivanjeknjige pozajmljivanje) {
        return pozajmljivanjeService.createPozajmljivanje(pozajmljivanje);
    }

    @PutMapping("/{idKorisnika}/{idKnjige}")
    public Pozajmljivanjeknjige updatePozajmljivanje(
            @PathVariable Integer idKorisnika, @PathVariable Integer idKnjige, @RequestBody Pozajmljivanjeknjige pozajmljivanje) {
        PozajmljivanjeknjigeId id = new PozajmljivanjeknjigeId();
        id.setIdKorisnika(idKorisnika);
        id.setIdKnjige(idKnjige);
        return pozajmljivanjeService.updatePozajmljivanje(id, pozajmljivanje);
    }

    @DeleteMapping("/{idKorisnika}/{idKnjige}")
    public void deletePozajmljivanje(@PathVariable Integer idKorisnika, @PathVariable Integer idKnjige) {
        PozajmljivanjeknjigeId id = new PozajmljivanjeknjigeId();
        id.setIdKorisnika(idKorisnika);
        id.setIdKnjige(idKnjige);
        pozajmljivanjeService.deletePozajmljivanje(id);
    }
}