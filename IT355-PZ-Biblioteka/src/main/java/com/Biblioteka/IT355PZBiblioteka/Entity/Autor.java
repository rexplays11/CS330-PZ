package com.Biblioteka.IT355PZBiblioteka.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autora")
    private Integer idAutora;

    @Column(name = "naziv_autora")
    private String nazivAutora;

    public Integer getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(Integer idAutora) {
        this.idAutora = idAutora;
    }

    public String getNazivAutora() {
        return nazivAutora;
    }

    public void setNazivAutora(String nazivAutora) {
        this.nazivAutora = nazivAutora;
    }
}