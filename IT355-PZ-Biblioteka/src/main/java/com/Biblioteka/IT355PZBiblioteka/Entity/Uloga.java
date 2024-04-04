package com.Biblioteka.IT355PZBiblioteka.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Uloga")
public class Uloga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uloge")
    private Integer idUloge;

    @Column(name = "ime_uloge_korisnika")
    private String imeUlogeKorisnika;

    public Integer getIdUloge() {
        return idUloge;
    }

    public void setIdUloge(Integer idUloge) {
        this.idUloge = idUloge;
    }

    public String getImeUlogeKorisnika() {
        return imeUlogeKorisnika;
    }

    public void setImeUlogeKorisnika(String imeUlogeKorisnika) {
        this.imeUlogeKorisnika = imeUlogeKorisnika;
    }
}