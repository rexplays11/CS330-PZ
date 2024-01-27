package com;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "autor", schema = "biblioteka_bazapodataka", catalog = "")
public class AutorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id_autora")
    private int idAutora;

    public int getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(int idAutora) {
        this.idAutora = idAutora;
    }

    @Basic
    @Column(name = "naziv_autora")
    private String nazivAutora;

    public String getNazivAutora() {
        return nazivAutora;
    }

    public void setNazivAutora(String nazivAutora) {
        this.nazivAutora = nazivAutora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorEntity that = (AutorEntity) o;
        return idAutora == that.idAutora && Objects.equals(nazivAutora, that.nazivAutora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutora, nazivAutora);
    }
}
