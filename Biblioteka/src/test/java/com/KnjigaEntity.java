package com;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "knjiga", schema = "biblioteka_bazapodataka", catalog = "")
public class KnjigaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_knjige")
    private int idKnjige;

    public int getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(int idKnjige) {
        this.idKnjige = idKnjige;
    }

    @Basic
    @Column(name = "naziv_knjige")
    private String nazivKnjige;

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    @Basic
    @Column(name = "id_autora")
    private Integer idAutora;

    public Integer getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(Integer idAutora) {
        this.idAutora = idAutora;
    }

    @Basic
    @Column(name = "id_izdavacka_kuca")
    private Integer idIzdavackaKuca;

    public Integer getIdIzdavackaKuca() {
        return idIzdavackaKuca;
    }

    public void setIdIzdavackaKuca(Integer idIzdavackaKuca) {
        this.idIzdavackaKuca = idIzdavackaKuca;
    }

    @Basic
    @Column(name = "kolicina")
    private Integer kolicina;

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnjigaEntity that = (KnjigaEntity) o;
        return idKnjige == that.idKnjige && Objects.equals(nazivKnjige, that.nazivKnjige) && Objects.equals(idAutora, that.idAutora) && Objects.equals(idIzdavackaKuca, that.idIzdavackaKuca) && Objects.equals(kolicina, that.kolicina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKnjige, nazivKnjige, idAutora, idIzdavackaKuca, kolicina);
    }
}
