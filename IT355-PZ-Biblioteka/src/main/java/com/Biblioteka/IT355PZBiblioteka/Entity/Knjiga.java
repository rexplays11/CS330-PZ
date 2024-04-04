package com.Biblioteka.IT355PZBiblioteka.Entity;

import jakarta.persistence.*;

;

@Entity
@Table(name = "Knjiga")
public class Knjiga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_knjige")
    private Integer idKnjige;

    @Column(name = "naziv_knjige")
    private String nazivKnjige;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Column(name = "zanr")
    private String zanr;

    @Column(name = "deskripcija")
    private String deskripcija;

    @Column(name = "slikaKnjige")
    private String slika;

    @ManyToOne
    @JoinColumn(name = "id_autora", referencedColumnName = "id_autora")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_izdavacka_kuca", referencedColumnName = "id_izdavacka_kuca")
    private IzdavackaKuca izdavackaKuca;

    public Integer getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(Integer idKnjige) {
        this.idKnjige = idKnjige;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public IzdavackaKuca getIzdavackaKuca() {
        return izdavackaKuca;
    }

    public void setIzdavackaKuca(IzdavackaKuca izdavackaKuca) {
        this.izdavackaKuca = izdavackaKuca;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getDeskripcija() {
        return deskripcija;
    }

    public void setDeskripcija(String deskripcija) {
        this.deskripcija = deskripcija;
    }
}