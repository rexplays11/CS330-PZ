package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.PozajmljivanjeKnjige;
import com.Biblioteka.IT355PZBiblioteka.Repository.PozajmljivanjeKnjigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

public interface PozajmljivanjeKnjigeService {
    List<PozajmljivanjeKnjige> getAllPozajmljivanja();
    PozajmljivanjeKnjige getPozajmljivanjeById(int id);
    PozajmljivanjeKnjige createPozajmljivanje(PozajmljivanjeKnjige pozajmljivanje);
    void updatePozajmljivanje(int id, PozajmljivanjeKnjige updatedPozajmljivanje);
    void deletePozajmljivanje(int id);
}