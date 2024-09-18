package org.example.api_aromapropio.perfumes.domain.services.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumeClassificationCommand;
import org.example.api_aromapropio.perfumes.domain.model.entities.PerfumesClassification;

import java.util.Optional;

public interface PerfumeClassificationCommandService {
    Optional<PerfumesClassification> handle(CreatePerfumeClassificationCommand command);
}
