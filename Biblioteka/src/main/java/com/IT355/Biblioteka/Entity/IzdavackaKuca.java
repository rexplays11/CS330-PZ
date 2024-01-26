package com.IT355.Biblioteka.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "izdavacka_kuca")
public class IzdavackaKuca {
    @Id
    @Column(name = "id_izdavacka_kuca", nullable = false)
    private Integer id;

    @Column(name = "naziv_izdavacke_kuce", nullable = false)
    private String nazivIzdavackeKuce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivIzdavackeKuce() {
        return nazivIzdavackeKuce;
    }

    public void setNazivIzdavackeKuce(String nazivIzdavackeKuce) {
        this.nazivIzdavackeKuce = nazivIzdavackeKuce;
    }

}