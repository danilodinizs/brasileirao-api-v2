package dev.danilodinizs.brasileirao_api.controller;

import dev.danilodinizs.brasileirao_api.repository.EstadioRepository;
import dev.danilodinizs.brasileirao_api.service.EstadioService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/estadios")
public class EstadioController {

    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }
}
