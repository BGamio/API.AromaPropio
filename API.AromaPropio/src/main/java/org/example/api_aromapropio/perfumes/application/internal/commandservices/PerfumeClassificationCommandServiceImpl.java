package org.example.api_aromapropio.perfumes.application.internal.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumeClassificationCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;
import org.example.api_aromapropio.perfumes.domain.services.commandservices.PerfumeClassificationCommandService;
import org.example.api_aromapropio.perfumes.infrastructure.jpa.repositories.PerfumesClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfumeClassificationCommandServiceImpl implements PerfumeClassificationCommandService {

    private final PerfumesClassificationRepository perfumesClassificationRepository;

    public PerfumeClassificationCommandServiceImpl(PerfumesClassificationRepository perfumesClassificationRepository) {
        this.perfumesClassificationRepository = perfumesClassificationRepository;
    }

    @Override
    public Optional<PerfumesClassification> handle(CreatePerfumeClassificationCommand command) {
        if (command.name().isBlank()) return Optional.empty();

        String name = command.name();
        String description = command.description();

        var perfumesClassification = new PerfumesClassification(name, description);
        var createdPerfumesClassification = perfumesClassificationRepository.save(perfumesClassification);
        return Optional.of(createdPerfumesClassification);
    }
}
