package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Autor;
import com.Biblioteka.IT355PZBiblioteka.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAutori() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Integer id, Autor autorDetails) {
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autor.setNazivAutora(autorDetails.getNazivAutora());
            return autorRepository.save(autor);
        }
        return null;
    }

    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}