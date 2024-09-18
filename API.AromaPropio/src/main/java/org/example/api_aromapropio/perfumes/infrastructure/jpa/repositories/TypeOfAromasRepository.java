package org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories;

import org.example.api_aromapropio.perfumes.domain.model.entities.TypeOfAromas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeOfAromasRepository  extends JpaRepository<TypeOfAromas, Long> {
    Optional<TypeOfAromas> findById(Long id);
}
