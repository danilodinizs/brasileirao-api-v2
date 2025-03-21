package dev.danilodinizs.brasileirao_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_estadio")
public class EstadioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cidade;
    private Integer capacidade;

    public EstadioEntity() {
    }

    public EstadioEntity(UUID id, String cidade, String nome, Integer capacidade) {
        this.id = id;
        this.cidade = cidade;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public UUID getId() {
        return id;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
