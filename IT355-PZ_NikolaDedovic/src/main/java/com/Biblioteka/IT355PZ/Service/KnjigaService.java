package com.Biblioteka.IT355PZ.Service;

import com.Biblioteka.IT355PZ.Entity.Knjiga;
import com.Biblioteka.IT355PZ.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnjigaService {

    private final KnjigaRepository knjigaRepository;

    @Autowired
    public KnjigaService(KnjigaRepository knjigaRepository) {
        this.knjigaRepository = knjigaRepository;
    }

    public List<Knjiga> getAllKnjige() {
        return knjigaRepository.findAll();
    }

    public Knjiga getKnjigaById(Integer id) {
        return knjigaRepository.findById(id).orElse(null);
    }

    public Knjiga createKnjiga(Knjiga knjiga) {
        return knjigaRepository.save(knjiga);
    }

    public Knjiga updateKnjiga(Integer id, Knjiga knjiga) {
        if (knjigaRepository.existsById(id)) {
            knjiga.setId(id);
            return knjigaRepository.save(knjiga);
        }
        return null; // Handle not found case
    }

    public void deleteKnjiga(Integer id) {
        knjigaRepository.deleteById(id);
    }
}