package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Uloga;
import com.Biblioteka.IT355PZBiblioteka.Repository.UlogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

public interface UlogaService {
    List<Uloga> getAllUloge();
    Uloga getUlogaById(Integer id);
    Uloga createUloga(Uloga uloga);
    Uloga updateUloga(Integer id, Uloga ulogaDetails);
    void deleteUloga(Integer id);
}