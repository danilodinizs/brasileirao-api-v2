package dev.danilodinizs.brasileirao_api.mappers;

import dev.danilodinizs.brasileirao_api.dto.TimeDTO;
import dev.danilodinizs.brasileirao_api.entity.EstadioEntity;
import dev.danilodinizs.brasileirao_api.entity.TimeEntity;

public class TimeMapper {

    public static TimeEntity toEntity(TimeDTO timeDTO) {
         return new TimeEntity(timeDTO.id(),
                 timeDTO.nome(),
                 timeDTO.sigla(),
                 timeDTO.acronimo(),
                 timeDTO.uf(),
                 EstadioMapper.toEntity(timeDTO.estadio()));
    }

    public static TimeDTO toDTO(TimeEntity timeEntity) {
        return new TimeDTO(timeEntity.getId(),
                timeEntity.getNome(),
                timeEntity.getSigla(),
                timeEntity.getAcronimo(),
                timeEntity.getUf(),
                EstadioMapper.toDTO(timeEntity.getEstadio()));
    }

}
