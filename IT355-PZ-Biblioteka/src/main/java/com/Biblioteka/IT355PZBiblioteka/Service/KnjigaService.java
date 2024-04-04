package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.Knjiga;
import com.Biblioteka.IT355PZBiblioteka.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> getAllKnjige() {
        return knjigaRepository.findAll();
    }

    public Knjiga getKnjigaById(Integer id) {
        return knjigaRepository.findById(id).orElse(null);
    }

    public Knjiga createKnjiga(Knjiga knjiga) {
        return knjigaRepository.save(knjiga);
    }

    public Knjiga updateKnjiga(Integer id, Knjiga knjigaDetails) {
        Knjiga knjiga = knjigaRepository.findById(id).orElse(null);
        if (knjiga != null) {
            knjiga.setNazivKnjige(knjigaDetails.getNazivKnjige());
            knjiga.setKolicina(knjigaDetails.getKolicina());
            knjiga.setZanr(knjigaDetails.getZanr());
            knjiga.setDeskripcija(knjigaDetails.getDeskripcija());
            knjiga.setSlika(knjigaDetails.getSlika());
            knjiga.setAutor(knjigaDetails.getAutor());
            knjiga.setIzdavackaKuca(knjigaDetails.getIzdavackaKuca());
            return knjigaRepository.save(knjiga);
        }
        return null;
    }

    public void deleteKnjiga(Integer id) {
        knjigaRepository.deleteById(id);
    }
}