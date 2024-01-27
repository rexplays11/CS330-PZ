package com;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "pozajmljivanjeknjige", schema = "biblioteka_bazapodataka", catalog = "")
@jakarta.persistence.IdClass(com.PozajmljivanjeknjigeEntityPK.class)
public class PozajmljivanjeknjigeEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PozajmljivanjeknjigeEntity that = (PozajmljivanjeknjigeEntity) o;
        return idKorisnika == that.idKorisnika && idKnjige == that.idKnjige;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnika, idKnjige);
    }
}
