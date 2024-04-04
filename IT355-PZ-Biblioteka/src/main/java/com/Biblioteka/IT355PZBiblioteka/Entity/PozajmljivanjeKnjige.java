package com.Biblioteka.IT355PZBiblioteka.Entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "PozajmljivanjeKnjige")
public class PozajmljivanjeKnjige {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pozajmljivanje")
    private int idPozajmljivanje;

    @Column(name = "id_korisnika")
    private int idKorisnika;

    @Column(name = "id_knjige")
    private int idKnjige;

    @Column(name = "broj_knjiga")
    private int brojKnjiga;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "datumIznamljivanja")
    private Date datumIznamljivanja;

    public int getIdPozajmljivanje() {
        return idPozajmljivanje;
    }

    public void setIdPozajmljivanje(int idPozajmljivanje) {
        this.idPozajmljivanje = idPozajmljivanje;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public int getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(int idKnjige) {
        this.idKnjige = idKnjige;
    }

    public int getBrojKnjiga() {
        return brojKnjiga;
    }

    public void setBrojKnjiga(int brojKnjiga) {
        this.brojKnjiga = brojKnjiga;
    }

    public Date getDatumIznamljivanja() {
        return datumIznamljivanja;
    }

    public void setDatumIznamljivanja(Date datumIznamljivanja) {
        this.datumIznamljivanja = datumIznamljivanja;
    }
}