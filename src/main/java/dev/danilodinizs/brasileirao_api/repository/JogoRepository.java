package dev.danilodinizs.brasileirao_api.repository;

import dev.danilodinizs.brasileirao_api.entity.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogoRepository extends JpaRepository<JogoEntity, UUID> {
}
