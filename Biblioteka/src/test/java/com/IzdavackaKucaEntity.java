package com;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "izdavacka_kuca", schema = "biblioteka_bazapodataka", catalog = "")
public class IzdavackaKucaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_izdavacka_kuca")
    private int idIzdavackaKuca;

    public int getIdIzdavackaKuca() {
        return idIzdavackaKuca;
    }

    public void setIdIzdavackaKuca(int idIzdavackaKuca) {
        this.idIzdavackaKuca = idIzdavackaKuca;
    }

    @Basic
    @Column(name = "naziv_izdavacke_kuce")
    private String nazivIzdavackeKuce;

    public String getNazivIzdavackeKuce() {
        return nazivIzdavackeKuce;
    }

    public void setNazivIzdavackeKuce(String nazivIzdavackeKuce) {
        this.nazivIzdavackeKuce = nazivIzdavackeKuce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IzdavackaKucaEntity that = (IzdavackaKucaEntity) o;
        return idIzdavackaKuca == that.idIzdavackaKuca && Objects.equals(nazivIzdavackeKuce, that.nazivIzdavackeKuce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIzdavackaKuca, nazivIzdavackeKuce);
    }
}
