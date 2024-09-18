package org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories;

import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumesClassificationRepository extends JpaRepository<PerfumesClassification, Long> {
    Optional<PerfumesClassification> findById(Long id);
    Optional<PerfumesClassification> findByName(String name);
}
