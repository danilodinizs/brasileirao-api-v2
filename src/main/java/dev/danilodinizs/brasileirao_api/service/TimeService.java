package dev.danilodinizs.brasileirao_api.service;

import dev.danilodinizs.brasileirao_api.dto.TimeDTO;
import dev.danilodinizs.brasileirao_api.entity.TimeEntity;
import dev.danilodinizs.brasileirao_api.mappers.EstadioMapper;
import dev.danilodinizs.brasileirao_api.mappers.TimeMapper;
import dev.danilodinizs.brasileirao_api.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void cadastrarTime(TimeDTO timeDTO) {
        TimeEntity entity = TimeMapper.toEntity(timeDTO);
        timeRepository.save(entity);
    }

    public List<TimeEntity> listarTimes() {
        return timeRepository.findAll();
    }

    public Optional<TimeEntity> findById(UUID id) {
        if (timeRepository.existsById(id)) {
            return timeRepository.findById(id);
        } else {
            throw new RuntimeException("Time não encontrado com o ID: " + id);
        }
    }

    public void atualizarTime(UUID id, TimeDTO timeDTO ) {
        Optional<TimeEntity> timeBuscado = timeRepository.findById(id);

        if (timeBuscado.isPresent()) {
            TimeEntity timeAtualizado = timeBuscado.get();

            timeAtualizado.setNome(timeDTO.nome());
            timeAtualizado.setAcronimo(timeDTO.sigla());
            timeAtualizado.setAcronimo(timeDTO.acronimo());
            timeAtualizado.setAcronimo(timeDTO.uf());
            timeAtualizado.setEstadio(EstadioMapper.toEntity(timeDTO.estadio()));

            timeRepository.save(timeAtualizado);
        } else {
            throw new RuntimeException("Time não encontrado com o ID: " + id);
        }
    }

    public void deletarTime(UUID id) {
        Optional<TimeEntity> timePraDeletar = timeRepository.findById(id);

        if(timePraDeletar.isPresent()) {
            timeRepository.delete(timePraDeletar.get());
        } else {
            throw new RuntimeException("Time não encontrado com o ID: " + id);
        }

    }
}
