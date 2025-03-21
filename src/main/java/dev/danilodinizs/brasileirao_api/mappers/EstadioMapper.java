package dev.danilodinizs.brasileirao_api.mappers;

import dev.danilodinizs.brasileirao_api.dto.EstadioDTO;
import dev.danilodinizs.brasileirao_api.entity.EstadioEntity;

public class EstadioMapper {

    public static EstadioEntity toEntity(EstadioDTO estadioDTO) {
        return new EstadioEntity(estadioDTO.id(),
                estadioDTO.nome(),
                estadioDTO.cidade(),
                estadioDTO.capacidade());
    }

    public static EstadioDTO toDTO(EstadioEntity estadioEntity) {
        return new EstadioDTO(estadioEntity.getId(),
                estadioEntity.getNome(),
                estadioEntity.getCidade(),
                estadioEntity.getCapacidade());
    }
}
