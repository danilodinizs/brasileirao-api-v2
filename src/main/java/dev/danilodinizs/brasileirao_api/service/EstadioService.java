package dev.danilodinizs.brasileirao_api.service;

import dev.danilodinizs.brasileirao_api.dto.EstadioDTO;
import dev.danilodinizs.brasileirao_api.entity.EstadioEntity;
import dev.danilodinizs.brasileirao_api.mappers.EstadioMapper;
import dev.danilodinizs.brasileirao_api.repository.EstadioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstadioService {

    private final EstadioRepository estadioRepository;


    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    public void salvarEstadio(EstadioDTO estadioDTO) {
        estadioRepository.save(EstadioMapper.toEntity(estadioDTO));
    }

    public List<EstadioEntity> listarEstadios() {
        return estadioRepository.findAll();
    }

    public Optional<EstadioEntity> findById(UUID id) {
        if (estadioRepository.findById(id).isPresent()) {
            return estadioRepository.findById(id);
        } else {
                throw new RuntimeException("Estádio não encontrado com o ID: " + id);
        }
    }

    public void atualizarEstadio(UUID id, EstadioDTO estadioDTO) {
        Optional<EstadioEntity> estadioBuscado = estadioRepository.findById(id);

        if(estadioBuscado.isPresent()) {
            EstadioEntity estadioNovo = estadioBuscado.get();

            estadioNovo.setNome(estadioDTO.nome());
            estadioNovo.setCidade(estadioDTO.cidade());
            estadioNovo.setCapacidade(estadioDTO.capacidade());

            estadioRepository.save(estadioNovo);
        } else {
            throw new RuntimeException("Estádio não encontrado com o ID: " + id);
        }
    }

    public void deletarEstadio(UUID id) {
        Optional<EstadioEntity> deletar = estadioRepository.findById(id);

        if (deletar.isPresent()) {
            estadioRepository.delete(deletar.get());
        } else {
            throw new RuntimeException("Estádio não encontrado com o ID: " + id);
        }
    }
}
