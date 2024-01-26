package com.IT355.Biblioteka.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pozajmljivanjeknjige")
public class Pozajmljivanjeknjige {
    @EmbeddedId
    private PozajmljivanjeknjigeId id;

    @MapsId("idKorisnika")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_korisnika", nullable = false)
    private Korisnik idKorisnika;

    @MapsId("idKnjige")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_knjige", nullable = false)
    private Knjiga idKnjige;

    public PozajmljivanjeknjigeId getId() {
        return id;
    }

    public void setId(PozajmljivanjeknjigeId id) {
        this.id = id;
    }

    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Knjiga getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(Knjiga idKnjige) {
        this.idKnjige = idKnjige;
    }

}