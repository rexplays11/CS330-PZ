package com.Biblioteka.IT355PZBiblioteka.Entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "pozajmljivanje_knjige")
public class PozajmljivanjeKnjige {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pozajmljivanje")
    private Integer idPozajmljivanje;

    @Column(name = "id_knjige")
    private Integer idKnjige;

    @Column(name = "id_korisnika")
    private Integer idKorisnika;

    @Column(name = "datum_iznamljivanja")
    private LocalDate datumIznamljivanja;

    public Integer getIdPozajmljivanje() {
        return idPozajmljivanje;
    }

    public void setIdPozajmljivanje(Integer idPozajmljivanje) {
        this.idPozajmljivanje = idPozajmljivanje;
    }

    public Integer getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(Integer idKnjige) {
        this.idKnjige = idKnjige;
    }

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public LocalDate getDatumIznamljivanja() {
        return datumIznamljivanja;
    }

    public void setDatumIznamljivanja(LocalDate datumIznamljivanja) {
        this.datumIznamljivanja = datumIznamljivanja;
    }
}