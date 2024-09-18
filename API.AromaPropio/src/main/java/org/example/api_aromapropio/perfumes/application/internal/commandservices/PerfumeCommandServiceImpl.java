package org.example.api_aromapropio.perfumes.application.internal.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreateOlfactoryFamiliesCommand;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumesCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.OlfactoryFamilies;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.PerfumeCommandService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.OlfactoryFamiliesRepository;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.PerfumeRepository;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.PerfumesClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfumeCommandServiceImpl implements PerfumeCommandService {

    private final PerfumeRepository perfumeRepository;

    public PerfumeCommandServiceImpl(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    @Override
    public Optional<Perfume> handle(CreatePerfumesCommand command) {
        if (command.name().isEmpty())  return Optional.empty();
        var perfume = new Perfume(command);
        perfumeRepository.save(perfume);
        return Optional.of(perfume);
    }
}
