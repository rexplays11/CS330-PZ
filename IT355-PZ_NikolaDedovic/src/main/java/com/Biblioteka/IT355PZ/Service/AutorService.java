package com.Biblioteka.IT355PZ.Service;

import com.Biblioteka.IT355PZ.Entity.Autor;
import com.Biblioteka.IT355PZ.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAllAutors() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Integer id, Autor autor) {
        if (autorRepository.existsById(id)) {
            autor.setId(id);
            return autorRepository.save(autor);
        }
        return null; // Handle not found case
    }

    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}