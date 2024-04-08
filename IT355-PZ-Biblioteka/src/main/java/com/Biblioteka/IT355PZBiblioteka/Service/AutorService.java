package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Autor;
import com.Biblioteka.IT355PZBiblioteka.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

public interface AutorService {
    List<Autor> getAllAutori();
    Autor getAutorById(Integer id);
    Autor createAutor(Autor autor);
    Autor updateAutor(Integer id, Autor autorDetails);
    void deleteAutor(Integer id);
}