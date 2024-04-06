package com.Biblioteka.IT355PZBiblioteka.Entity;

import jakarta.persistence.*;



@Entity
@Table(name = "Korisnik")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_korisnika")
    private Integer idKorisnika;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "lozinka")
    private String lozinka;

    @Column(name = "email")
    private String email;
    @Column(name = "id_uloge")
    private Integer idUloge;

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getIdUloge() {
        return idUloge;
    }

    public void setIdUloge(Integer idUloge) {
        this.idUloge = idUloge;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String nazive) {
        this.naziv = nazive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}