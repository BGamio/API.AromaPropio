package org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    Optional<Perfume> findById(Long id);
    Optional<Perfume> findByName(String name);
}
