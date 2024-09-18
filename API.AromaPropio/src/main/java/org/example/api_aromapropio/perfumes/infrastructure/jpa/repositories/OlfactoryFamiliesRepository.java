package org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories;

import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OlfactoryFamiliesRepository extends JpaRepository<OlfactoryFamilies, Long> {
    Optional<OlfactoryFamilies> findById(Long id);
    Optional<OlfactoryFamilies> findByName(String name);
    List<OlfactoryFamilies> findAll();
}
