package com.Biblioteka.IT355PZ.Controller;

import com.Biblioteka.IT355PZ.Entity.IzdavackaKuca;
import com.Biblioteka.IT355PZ.Service.IzdavackaKucaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/izdavacke-kuce")
public class IzdavackaKucaController {

    private final IzdavackaKucaService izdavackaKucaService;

    @Autowired
    public IzdavackaKucaController(IzdavackaKucaService izdavackaKucaService) {
        this.izdavackaKucaService = izdavackaKucaService;
    }

    @GetMapping
    public List<IzdavackaKuca> getAllIzdavackaKuce() {
        return izdavackaKucaService.getAllIzdavackaKuce();
    }

    @GetMapping("/{id}")
    public IzdavackaKuca getIzdavackaKucaById(@PathVariable Integer id) {
        return izdavackaKucaService.getIzdavackaKucaById(id);
    }

    @PostMapping
    public IzdavackaKuca createIzdavackaKuca(@RequestBody IzdavackaKuca izdavackaKuca) {
        return izdavackaKucaService.createIzdavackaKuca(izdavackaKuca);
    }

    @PutMapping("/{id}")
    public IzdavackaKuca updateIzdavackaKuca(@PathVariable Integer id, @RequestBody IzdavackaKuca izdavackaKuca) {
        return izdavackaKucaService.updateIzdavackaKuca(id, izdavackaKuca);
    }

    @DeleteMapping("/{id}")
    public void deleteIzdavackaKuca(@PathVariable Integer id) {
        izdavackaKucaService.deleteIzdavackaKuca(id);
    }
}