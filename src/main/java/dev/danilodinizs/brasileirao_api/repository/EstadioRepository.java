package dev.danilodinizs.brasileirao_api.repository;

import dev.danilodinizs.brasileirao_api.entity.EstadioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstadioRepository extends JpaRepository<EstadioEntity, UUID> {
}
