package com.Biblioteka.IT355PZ.Controller;

import com.Biblioteka.IT355PZ.Entity.Autor;
import com.Biblioteka.IT355PZ.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autors")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> getAllAutors() {
        return autorService.getAllAutors();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Integer id) {
        return autorService.getAutorById(id);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.createAutor(autor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        return autorService.updateAutor(id, autor);
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Integer id) {
        autorService.deleteAutor(id);
    }
}