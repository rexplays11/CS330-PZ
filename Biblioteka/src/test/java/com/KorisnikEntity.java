package com;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "korisnik", schema = "biblioteka_bazapodataka", catalog = "")
public class KorisnikEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_korisnika")
    private int idKorisnika;

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    @Basic
    @Column(name = "ime")
    private String ime;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "prezime")
    private String prezime;

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "id_uloge")
    private Integer idUloge;

    public Integer getIdUloge() {
        return idUloge;
    }

    public void setIdUloge(Integer idUloge) {
        this.idUloge = idUloge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KorisnikEntity that = (KorisnikEntity) o;
        return idKorisnika == that.idKorisnika && Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(idUloge, that.idUloge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnika, ime, prezime, idUloge);
    }
}
