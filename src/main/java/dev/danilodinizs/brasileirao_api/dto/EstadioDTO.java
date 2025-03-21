package dev.danilodinizs.brasileirao_api.dto;

import java.util.UUID;

public record EstadioDTO(UUID id,
            String nome,
            String cidade,
            Integer capacidade) {
}
