package com.Biblioteka.IT355PZBiblioteka.Service;

import com.Biblioteka.IT355PZBiblioteka.Entity.IzdavackaKuca;

import java.util.List;

public interface IzdavackaKucaService {
    List<IzdavackaKuca> getAllIzdavackeKuce();
    IzdavackaKuca getIzdavackaKucaById(Integer id);
    IzdavackaKuca createIzdavackaKuca(IzdavackaKuca izdavackaKuca);
    IzdavackaKuca updateIzdavackaKuca(Integer id, IzdavackaKuca izdavackaKucaDetails);
    void deleteIzdavackaKuca(Integer id);
}