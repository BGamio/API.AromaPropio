package org.example.api_aromapropio.perfumes.domain.services.commandservices;

import org.example.api_aromapropio.perfumes.domain.model.aggregates.Perfume;
import org.example.api_aromapropio.perfumes.domain.model.commands.CreatePerfumesCommand;

import java.util.Optional;

public interface PerfumeCommandService {
    Optional<Perfume> handle(CreatePerfumesCommand command);
}
