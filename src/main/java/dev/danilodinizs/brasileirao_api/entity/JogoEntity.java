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
@Table(name = "tb_jogo")
public class JogoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer golsCasa;
    private Integer golsVisitante;
    private Integer publico;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    private TimeEntity casa;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private TimeEntity visitante;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private EstadioEntity estadio;
}
