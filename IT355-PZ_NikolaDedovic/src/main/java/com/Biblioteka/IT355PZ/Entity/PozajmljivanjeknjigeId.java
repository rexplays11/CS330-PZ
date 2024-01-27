package com.Biblioteka.IT355PZ.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PozajmljivanjeknjigeId implements Serializable {
    private static final long serialVersionUID = 2182415586127300234L;
    @Column(name = "id_korisnika", nullable = false)
    private Integer idKorisnika;

    @Column(name = "id_knjige", nullable = false)
    private Integer idKnjige;

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Integer getIdKnjige() {
        return idKnjige;
    }

    public void setIdKnjige(Integer idKnjige) {
        this.idKnjige = idKnjige;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PozajmljivanjeknjigeId entity = (PozajmljivanjeknjigeId) o;
        return Objects.equals(this.idKorisnika, entity.idKorisnika) &&
                Objects.equals(this.idKnjige, entity.idKnjige);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKorisnika, idKnjige);
    }

}