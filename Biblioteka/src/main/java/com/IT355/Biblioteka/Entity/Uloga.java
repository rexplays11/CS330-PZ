package com.IT355.Biblioteka.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "uloga")
public class Uloga {
    @Id
    @Column(name = "id_uloge", nullable = false)
    private Integer id;

    @Column(name = "ime_uloge_korisnika", nullable = false)
    private String imeUlogeKorisnika;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeUlogeKorisnika() {
        return imeUlogeKorisnika;
    }

    public void setImeUlogeKorisnika(String imeUlogeKorisnika) {
        this.imeUlogeKorisnika = imeUlogeKorisnika;
    }

}