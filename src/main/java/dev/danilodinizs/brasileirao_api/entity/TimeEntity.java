package dev.danilodinizs.brasileirao_api.entity;

import dev.danilodinizs.brasileirao_api.dto.EstadioDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.UUID;



@Entity
@Table(name = "tb_time")
public class TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 40)
    private String nome;
    @Column(length = 3)
    private String sigla;
    @Column(length = 4)
    private String acronimo;
    @Column(length = 2, name = "estado")
    private String uf;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadio_id")
    private EstadioEntity estadio;

    public TimeEntity() {
    }

    public TimeEntity(UUID id, String nome, String sigla, String acronimo, String uf, EstadioEntity estadio) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.acronimo = acronimo;
        this.uf = uf;
        this.estadio = estadio;
    }

    public UUID getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public EstadioEntity getEstadio() {
        return estadio;
    }

    public void setEstadio(EstadioEntity estadio) {
        this.estadio = estadio;
    }
}