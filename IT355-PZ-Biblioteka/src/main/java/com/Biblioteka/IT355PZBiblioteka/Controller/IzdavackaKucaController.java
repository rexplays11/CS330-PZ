package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.IzdavackaKuca;
import com.Biblioteka.IT355PZBiblioteka.Service.IzdavackaKucaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/izdavacke-kuce")
public class IzdavackaKucaController {

    @Autowired
    private IzdavackaKucaService izdavackaKucaService;

    @GetMapping("/")
    public List<IzdavackaKuca> getAllIzdavackeKuce() {
        return izdavackaKucaService.getAllIzdavackeKuce();
    }

    @GetMapping("/{id}")
    public IzdavackaKuca getIzdavackaKucaById(@PathVariable Integer id) {
        return izdavackaKucaService.getIzdavackaKucaById(id);
    }

    @PostMapping("/")
    public IzdavackaKuca createIzdavackaKuca(@RequestBody IzdavackaKuca izdavackaKuca) {
        return izdavackaKucaService.createIzdavackaKuca(izdavackaKuca);
    }

    @PutMapping("/{id}")
    public IzdavackaKuca updateIzdavackaKuca(@PathVariable Integer id, @RequestBody IzdavackaKuca izdavackaKucaDetails) {
        return izdavackaKucaService.updateIzdavackaKuca(id, izdavackaKucaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteIzdavackaKuca(@PathVariable Integer id) {
        izdavackaKucaService.deleteIzdavackaKuca(id);
    }
}