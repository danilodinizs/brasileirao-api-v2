package dev.danilodinizs.brasileirao_api.dto;

import dev.danilodinizs.brasileirao_api.entity.EstadioEntity;

import java.util.UUID;

public record TimeDTO(UUID id,
                      String nome,
                      String sigla,
                      String acronimo,
                      String uf,
                      EstadioDTO estadio) {
}
