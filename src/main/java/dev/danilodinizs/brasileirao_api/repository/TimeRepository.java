package dev.danilodinizs.brasileirao_api.repository;

import dev.danilodinizs.brasileirao_api.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeRepository extends JpaRepository<TimeEntity, UUID> {
}
