package com.Biblioteka.IT355PZBiblioteka.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Izdavacka_kuca")
public class IzdavackaKuca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_izdavacka_kuca")
    private Integer idIzdavackaKuca;

    @Column(name = "naziv_izdavacke_kuce")
    private String nazivIzdavackeKuce;

    public Integer getIdIzdavackaKuca() {
        return idIzdavackaKuca;
    }

    public void setIdIzdavackaKuca(Integer idIzdavackaKuca) {
        this.idIzdavackaKuca = idIzdavackaKuca;
    }

    public String getNazivIzdavackeKuce() {
        return nazivIzdavackeKuce;
    }

    public void setNazivIzdavackeKuce(String nazivIzdavackeKuce) {
        this.nazivIzdavackeKuce = nazivIzdavackeKuce;
    }
}