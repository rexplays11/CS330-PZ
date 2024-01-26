package com.IT355.Biblioteka.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "knjiga")
public class Knjiga {
    @Id
    @Column(name = "id_knjige", nullable = false)
    private Integer id;

    @Column(name = "naziv_knjige", nullable = false)
    private String nazivKnjige;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_izdavacka_kuca")
    private IzdavackaKuca idIzdavackaKuca;

    @Column(name = "kolicina")
    private Integer kolicina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public IzdavackaKuca getIdIzdavackaKuca() {
        return idIzdavackaKuca;
    }

    public void setIdIzdavackaKuca(IzdavackaKuca idIzdavackaKuca) {
        this.idIzdavackaKuca = idIzdavackaKuca;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

}