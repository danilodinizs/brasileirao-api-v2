package dev.danilodinizs.brasileirao_api.controller;

import dev.danilodinizs.brasileirao_api.dto.TimeDTO;
import dev.danilodinizs.brasileirao_api.entity.TimeEntity;
import dev.danilodinizs.brasileirao_api.mappers.EstadioMapper;
import dev.danilodinizs.brasileirao_api.mappers.TimeMapper;
import dev.danilodinizs.brasileirao_api.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;


    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarTime(@RequestBody TimeDTO timeDTO) {
        timeService.cadastrarTime(timeDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TimeEntity>> buscarTimes() {
        List<TimeEntity> times = timeService.listarTimes();
        return ResponseEntity.status(HttpStatus.OK).body(times);
    }

    @PostMapping("/times/{id}")
    public ResponseEntity<String> atualizarTime(@PathVariable(value = "id")UUID id, @RequestBody TimeDTO timeDTO) {
        Optional<TimeEntity> timeASerAtualizado = timeService.findById(id);

        TimeEntity timeEntity = timeASerAtualizado.get();

        timeEntity.setNome(timeDTO.nome());
        timeEntity.setSigla(timeDTO.sigla());
        timeEntity.setAcronimo(timeDTO.acronimo());
        timeEntity.setUf(timeDTO.uf());
        timeEntity.setEstadio(EstadioMapper.toEntity(timeDTO.estadio()));

        timeService.cadastrarTime(TimeMapper.toDTO(timeEntity));

        return ResponseEntity.status(HttpStatus.OK).body("Parabém!");
    }

}
