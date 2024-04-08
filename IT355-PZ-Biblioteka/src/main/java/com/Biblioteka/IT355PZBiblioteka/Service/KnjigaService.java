package com.Biblioteka.IT355PZBiblioteka.Service;


import com.Biblioteka.IT355PZBiblioteka.Entity.Knjiga;

import java.util.List;

public interface KnjigaService {
    List<Knjiga> getAllKnjige();
    Knjiga getKnjigaById(Integer id);
    Knjiga createKnjiga(Knjiga knjiga);
    Knjiga updateKnjiga(Integer id, Knjiga knjigaDetails);
    void deleteKnjiga(Integer id);
}