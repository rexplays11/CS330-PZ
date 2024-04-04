package com.Biblioteka.IT355PZBiblioteka.Controller;

import com.Biblioteka.IT355PZBiblioteka.Entity.Autor;
import com.Biblioteka.IT355PZBiblioteka.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autori")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/")
    public List<Autor> getAllAutori() {
        return autorService.getAllAutori();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Integer id) {
        return autorService.getAutorById(id);
    }

    @PostMapping("/")
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.createAutor(autor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Integer id, @RequestBody Autor autorDetails) {
        return autorService.updateAutor(id, autorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Integer id) {
        autorService.deleteAutor(id);
    }
}